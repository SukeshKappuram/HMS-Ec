<%-- 
    Document   : index
    Created on : Nov 22, 2016, 8:01:59 PM
    Author     : iamsu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HMS</title>
        <style type="text/css">
 

  .leftBody{
      float: left;
      margin-left: 100px;
      width: 30%;
  }
  .rightBody{
      float: right;
      width: 20%;
  }
  .iImage{
      width: 80px;
      height: 80px;
      padding: 3px 2px 3px 2px;
  }
  
  .iPlus{
      text-align: center;
  }
</style>

    </head>
    <body>
        <%@include file="header.jsp" %>
          <div id="Home" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#Home" data-slide-to="0" class="dot"></li>
      <li data-target="#Home" data-slide-to="1" class="dot"></li>
      <li data-target="#Home" data-slide-to="2" class="dot"></li>
      <li data-target="#Home" data-slide-to="3" class="dot"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="http://www.suvarna.co.in/UserImages/8782f84611d745f09ec40847d8033efb.png" alt="Chania" style="width:100%;height: 350px;">
      </div>

      <div class="item">
        <img src="http://rsshospital.com/Image/BAN7.jpg" alt="Chania" style="width: 100%;height: 350px;" >
      </div>
    
      <div class="item">
        <img src="http://digitalsalutem.com/wp-content/uploads/2016/06/digitalhealth-banner.jpg" alt="Flower" style="width: 100%;height: 350px;" >
      </div>

      <div class="item">
        <img src="http://www.metricstream.com/sites/default/files/zurich%20home%20banner.jpg" alt="Flower" style="width: 100%;height: 350px;" >
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#Home" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#Home" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
<!-- Body -->
        <div>
            <div class="leftBody">
                <div class="iPlus">
                    <br/>
                    <img class="iImage" src="http://www.freeiconspng.com/uploads/hospital-icon-3.png" alt="clinics"/><br/>
                    <img class="iImage" src="http://www.webcluesinfotech.com/wp-content/uploads/2015/05/hospital-icon.png" alt="Hospitals"/>
                    <img class="iImage" src="https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRqM9Bgy_M6TqbAlfBVvW4Qaoh9wTSvRd_c1ip5o-rWhVr4EWFI" alt="first-aid"/>
                    <img class="iImage" src="http://i1309.photobucket.com/albums/s638/MalayanInsurancePH/icon_10_HospitalizationInsurance_zps0c038535.png" alt="Hospitalization"/><br/>
                    <img class="iImage" src="http://dev.cvsdevelopment.co.uk/mivet/wp-content/uploads/2015/03/labs_icon.jpg" alt="labs"/>
                </div>
            </div>
        </div>
        <br/>
        
        
        <div style="float: left;">
            <c:if test="${empty param.r}">
                <%@include file="aboutUs.jsp" %>
            </c:if>
            <c:if test="${not empty param.r}">
                <%@include file="Login.jsp" %>
            </c:if>
        </div>
        
        <div class="rightBody">
            
            <div class="menu">
                <br/><a href="">About Us</a><br/>
                <br/><a href="">&nbsp;Feedback </a><br/>
                <br/><a href="">Contact Us</a><br/>
            </div>
        </div>
        <div class="search">
            <form>
                <div id="container">
                    <div id="search-container" >
                        <button type="submit" class="btn btn-primary btn-sm" style="float: right;">Search</button>
                        <input id="search" class="form-control input-sm" maxlength="64" type="text" style="float: right;" placeholder="Search"/>
                        <ul></ul>
                    </div>
                </div>
            </form>
            <div>
            <img class="dImage" src="http://katarzyna-parkot.pl/img/tooth.png" alt="Dental"/>
            <img class="dImage" src="http://www.graybill.org/wp-content/uploads/2016/03/cardiology-icon.png" alt="cardiologist"/>
            <img class="dImage" src="https://practo-fabric.s3.amazonaws.com/chatterjee-skin-care-center-delhi-1446450760-563716483e7cc.jpg" alt="Dermatologist"/>
            <img class="dImage" src="https://cdn2.iconfinder.com/data/icons/medical-specialties-1/256/Neurology-512.png" alt="Neurologist"/>
            <img class="dImage" src="http://unconfirmedbreakingnews.com/wp-content/uploads/2014/03/8059487-757877-head-brain-vector-icon.jpg" alt="Psychiatrist"/>
            <img class="dImage" src="http://rathiorthoclinic.com/images/knee-icon2.png" alt="Orthopedic Surgeon"/>
            <img class="dImage" src="http://www.ogdenclinic.com/Static/ENT/desktop/img/throatIcon_2x.png" alt="ENT Specialist"/>
            <img class="dImage" src="http://www.mcw.edu/Medical-School-FileLibrary/DEPT-Graduate-School/icons/large/Grad_Physiology_Icon.png" alt="Physiologist"/>
            </div>
        </div>
        <%@include file="footer.html" %>
    </body>
</html>
