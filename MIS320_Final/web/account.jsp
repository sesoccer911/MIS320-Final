<%-- 
    Document   : account
    Created on : Apr 16, 2017, 8:17:07 PM
    Author     : ewaremickens
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Customer Account</title>
    </head>
       
             <form method="POST" action='' name="">
            First Name : <input
                type="text" name="firstName"
                value="<c:out value="${}" />" /> <br /> 
            Last Name : <input
                type="text" name="lastName"
                value="<c:out value="${}" />" /> <br /> 
            Password : <input
                type="text" name="dob"
                value="<c:out value="${} />" /> <br /> 
            Email : <input type="text" name="email"
                           value="<c:out value="${}" />" /> <br /> <input
                           type="submit" value="Submit" />
        </form>
     
        
        <button type="button" class=" "> View Cart</button>
        
        <label><b>Payment Method</b></label>
            <div class="dropdown">
            <button onclick=" " class="dropbtn"></button>
            <div id=" " class="dropdown-content">
            <a href="#">Link 1</a>
            <a href="#">Link 2</a>
            <a href="#">Link 3</a>
            </div>
            </div>
        
        <button type="button"  class=" ">Add Payment Method</button>
        
        <label><b> Current Rentals </b></label>
        <h:form styleClass="jsfcrud_list_form">
                <h:commandLink action="#{}" value="Previous #{}" rendered="#{}"/> 
                <h:commandLink action="#{}" value="Next #{}" rendered="#{}"/> 
                <h:dataTable value="#{}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Title"/>
                        </f:facet>
                        <h:outputText value="#{}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Return Date"/>
                        </f:facet>
                        <h:outputText value="#{}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Days Past Due"/>
                        </f:facet>
                        <h:outputText value="#{}}"/>
                    </h:column>
                   </h:dataTable>
                <br/>
            </h:form>
       
        <label><b> Rental History </b></label>
        <h:form styleClass="jsfcrud_list_form">
                <h:commandLink action="#{}" value="Previous #{}" rendered="#{}"/> 
                <h:commandLink action="#{}" value="Next #{}" rendered="#{}"/> 
                <h:dataTable value="#{}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Title"/>
                        </f:facet>
                        <h:outputText value="#{}"/>
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Return Date"/>
                        </f:facet>
                        <h:outputText value="#{}"/>
                    </h:column>
                   </h:dataTable>
                <br/>
            </h:form>
        
        <label><b> Wishlist </b></label>
        <h:form styleClass="jsfcrud_list_form">
                <h:commandLink action="#{}" value="Previous #{}" rendered="#{}"/> 
                <h:commandLink action="#{}" value="Next #{}" rendered="#{}"/> 
                <h:dataTable value="#{}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                    <h:column>
                        <f:facet name="header">
                            <h:outputText value="Title"/>
                        </f:facet>
                        <h:outputText value="#{}"/>
                    </h:column>
                   </h:dataTable>
                <br/>
            </h:form>
   
</html>
