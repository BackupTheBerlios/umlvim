package fr.umlv.desperados.struts.form;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.apache.struts.upload.MultipartRequestHandler;


/**
 *
 * @author ndedanil
 */

public class UploadStyleSheetForm extends ActionForm
{
    public static final String ERROR_PROPERTY_MAX_LENGTH_EXCEEDED = "org.apache.struts.webapp.upload.MaxLengthExceeded";


    /**
     * The value of the text the user has sent as form data
     */
    protected String theName;

    /**
     * The file that the user has uploaded
     */
    protected FormFile theFile;


    /**
     * Retrieve the value of the text the user has sent as form data
     */
    public String getTheName() {
        return theName;
    }

    /**
     * Set the value of the form data text
     */
    public void setTheName(String theName) {
        this.theName = theName;
    }

    /**
     * Retrieve a representation of the file the user has uploaded
     */
    public FormFile getTheFile() {
        return theFile;
    }

    /**
     * Set a representation of the file the user has uploaded
     */
    public void setTheFile(FormFile theFile) {
        this.theFile = theFile;
    }

    public void reset() {
       // writeFile = false;
    }

    /**
     * Check to make sure the client hasn't exceeded the maximum allowed upload size inside of this
     * validate method.
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
    {
        ActionErrors errors = new ActionErrors();
        //has the maximum length been exceeded?
        Boolean maxLengthExceeded = (Boolean)
                request.getAttribute(MultipartRequestHandler.ATTRIBUTE_MAX_LENGTH_EXCEEDED);
        if ((maxLengthExceeded != null) && (maxLengthExceeded.booleanValue()))
        {
            errors.add(ERROR_PROPERTY_MAX_LENGTH_EXCEEDED, new ActionError("maxLengthExceeded"));
        }
        return errors;

    }
}
