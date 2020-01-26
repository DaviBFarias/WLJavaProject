package utility;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.dispatcher.Dispatcher;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.UnknownHandler;
import com.opensymphony.xwork2.XWorkException;
import com.opensymphony.xwork2.config.ConfigurationManager;
import com.opensymphony.xwork2.config.RuntimeConfiguration;
import com.opensymphony.xwork2.config.entities.ActionConfig;

public class PageNotFoundAction extends ActionSupport implements UnknownHandler{

	private static final long serialVersionUID = 1L;

	@Actions({
        @Action(value = "pageNotFound", results = @Result(name = "success", location = "error.jsp")) })
	public String execute() {
		ServletActionContext.getResponse().setStatus(HttpServletResponse.SC_NOT_FOUND);
		addActionMessage(getText("error.pagenotfound"));
        return SUCCESS;
    }
	@Override
	 public ActionConfig handleUnknownAction(String namespace, String actionName)
            throws XWorkException {       
        ConfigurationManager configurationManager = Dispatcher.getInstance().getConfigurationManager();
        RuntimeConfiguration runtimeConfiguration = configurationManager.getConfiguration().getRuntimeConfiguration();
        ActionConfig actionConfig = runtimeConfiguration.getActionConfig(namespace, actionName);
        if(actionConfig == null) { // invalid url request, and this need to be handled
            actionConfig = runtimeConfiguration.getActionConfig("", "pageNotFound");
        }
        return actionConfig;
    }
	
	@Override
    public Object handleUnknownActionMethod(Object arg0, String arg1) {
        return null;
    }
	@Override
    public com.opensymphony.xwork2.Result handleUnknownResult(
            ActionContext arg0, String arg1, ActionConfig arg2, String arg3)
            throws XWorkException {
        return null;
    }   
}
