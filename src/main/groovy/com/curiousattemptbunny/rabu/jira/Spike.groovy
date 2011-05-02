package com.curiousattemptbunny.rabu.jira

import com.atlassian.jira.rest.client.JiraRestClient 
import com.atlassian.jira.rest.client.NullProgressMonitor 
import com.atlassian.jira.rest.client.domain.Issue 
import com.atlassian.jira.rest.client.internal.jersey.JerseyJiraRestClientFactory 

class Spike {
	static void main(String[] args) {
		String url = "http://todo"
		String username = "todo"
		String password = "todo"
		String issueName = "todo"
        final JerseyJiraRestClientFactory factory = new JerseyJiraRestClientFactory()
        final URI jiraServerUri = new URI(url)
        final JiraRestClient restClient = factory.createWithBasicHttpAuthentication(jiraServerUri, username, password)
        final NullProgressMonitor pm = new NullProgressMonitor()
        final Issue issue = restClient.getIssueClient().getIssue(issueName, pm)
	}
}