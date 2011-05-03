package com.curiousattemptbunny.rabu.jira

import com.atlassian.jira.rpc.exception.RemoteException 
import com.atlassian.jira.rpc.soap.jirasoapservice_v2.JiraSoapService 
import com.atlassian.jira.rpc.soap.jirasoapservice_v2.JiraSoapServiceService 
import com.atlassian.jira.rpc.soap.jirasoapservice_v2.JiraSoapServiceServiceLocator 
import javax.xml.rpc.ServiceException 

class SOAPSession
{
    private JiraSoapServiceService jiraSoapServiceLocator
    private JiraSoapService jiraSoapService
    private String token

    public SOAPSession(URL webServicePort)
    {
        jiraSoapServiceLocator = new JiraSoapServiceServiceLocator()
        try
        {
            if (webServicePort == null)
            {
                jiraSoapService = jiraSoapServiceLocator.getJirasoapserviceV2()
            }
            else
            {
                jiraSoapService = jiraSoapServiceLocator.getJirasoapserviceV2(webServicePort)
                System.out.println("SOAP Session service endpoint at " + webServicePort.toExternalForm())
            }
        }
        catch (ServiceException e)
        {
            throw new RuntimeException("ServiceException during SOAPClient contruction", e)
        }
    }

    public SOAPSession()
    {
        this(null)
    }

    public void connect(String userName, String password) throws RemoteException
    {
        System.out.println("\tConnnecting via SOAP as : " + userName)
        token = getJiraSoapService().login(userName, password)
        System.out.println("\tConnected")
    }

    public String getAuthenticationToken()
    {
        return token
    }

    public JiraSoapService getJiraSoapService()
    {
        return jiraSoapService
    }

    public JiraSoapServiceService getJiraSoapServiceLocator()
    {
        return jiraSoapServiceLocator
    }
}