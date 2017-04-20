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
     <label><b>First Name</b></label>
     <label><b>Last Name</b></label>
     <label><b>Password</b></label>
     <label><b>Email</b></label>
        
        <button type="button"  class=" ">Submit Changes</button>
        
        <button type="button" class=" "> View Cart</button>
        
        <label><b>Payment Method</b></label>
            <div class="dropdown">
            <button onclick="myFunction()" class="dropbtn"></button>
            <div id="myDropdown" class="dropdown-content">
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
