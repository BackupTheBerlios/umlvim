/*
 * Créé le 16 janv. 2004
 *
 */
package fr.umlv.desperados.struts.action;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import fr.umlv.desperados.struts.form.UploadStyleSheetForm;
import fr.umlv.desperados.stylesheet.StyleSheet;
import fr.umlv.desperados.stylesheet.StyleSheetManager;
import fr.umlv.desperados.util.Constants;

/**
 * @author ndedanil
 *
 */
public class AddStyleSheetAction extends AdminAction {

	public ActionForward doExecute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {

		UploadStyleSheetForm styleSheetForm = (UploadStyleSheetForm) form;
		ActionErrors errors = form.validate(mapping, request);

		StyleSheetManager manager =
			(StyleSheetManager) servlet.getServletContext().getAttribute(
				Constants.STYLESHEET_DATABASE_KEY);

		if (manager == null) {
			errors.add(
				ActionErrors.GLOBAL_ERROR,
				new ActionError("error.database.missing"));
		}

		if (!errors.isEmpty()) {
			saveErrors(request, errors);
			return (mapping.findForward("error"));
		}


		//retrieve the name data
		String name = styleSheetForm.getTheName();

		//retrieve the file representation
		FormFile file = styleSheetForm.getTheFile();

		//retrieve the file name
		String fileName= file.getFileName();

		//retrieve the content type
		String contentType = file.getContentType();
		String path = servlet.getServletContext().getRealPath("/") + "/stylesheet/"+fileName;

		try {
			//retrieve the file data
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			InputStream stream = file.getInputStream();

			//write the file to the file specified
			OutputStream bos = new FileOutputStream(path);
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
				bos.write(buffer, 0, bytesRead);
			}
			bos.close();

			//close the stream
			stream.close();
		}
		catch (FileNotFoundException fnfe) {
			return mapping.findForward("error");
		}
		catch (IOException ioe) {
			return mapping.findForward("error");
		}

		file.destroy();
		
		StyleSheet styleSheet = new StyleSheet(fileName,name);
		manager.addStyleSheet(styleSheet);

		return mapping.findForward("success");
	}
}

