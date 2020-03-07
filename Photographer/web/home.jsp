<%-- 
    Document   : home
    Created on : Mar 7, 2020, 12:13:37 AM
    Author     : ANH DUC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>My front page - us-123photo.simplesite.com</title>
        <link rel="stylesheet" type="text/css"
              href="./Style/8596505.design.v26374.css">

        <script type="text/javascript" src="./Style/frontendApp.min.js"></script>
    </head>
    <body data-pid="410915065" data-iid="">
        <div class="container-fluid site-wrapper">
            <!-- this is the Sheet -->
            <div class="container-fluid header-wrapper " id="header">
                <!-- this is the Header Wrapper -->
                <div class="container">
                    <div class="navbar navbar-compact">
                        <div class="navbar-inner">
                            <div class="container">
                                <!-- .btn-navbar is used as the toggle for collapsed navbar content -->
                                <a rel="nofollow" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"
                                   title="Toggle menu">
                                    <span class="menu-name">Menu</span>
                                    <span class="menu-bars">
                                        <span class="icon-bar"></span>
                                        <span class="icon-bar"></span>
                                        <span class="icon-bar"></span>
                                    </span>
                                </a>



                                <!-- Everything you want hidden at 940px or less, place within here -->
                                <div class="nav-collapse collapse">
                                    <ul class="nav" id="topMenu" data-submenu="horizontal">
                                        <li class=" active " style="">
                                            <a rel="nofollow"
                                               href="HomeController">My front
                                                page</a>
                                        </li>
                                        <c:forEach items="${listGallery}" var="gallery">
                                            <li class="  " style="">
                                                <a rel="nofollow" href="GalleryController?id=${gallery.id}">${gallery.name}</a>
                                            </li>
                                        </c:forEach>
                                        <li class="  " style="">
                                            <a rel="nofollow"
                                               href="ContactController">Contact</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- this is the Menu content -->
                    <div class="title-wrapper">
                        <div class="title-wrapper-inner">
                            <a style="float: left;" href="#">
                                <img src="Image/camera.png" style="width: 76.5px">
                            </a>
                            <div class="title ">
                                PHOTOGRAPHER
                            </div>
                            <div class="subtitle">
                                Welcome to this website
                            </div>
                        </div>
                    </div> <!-- these are the titles -->
                </div>
            </div> <!-- this is the Header content -->

            <div class="container-fluid content-wrapper" id="content">
                <!-- this is the Content Wrapper -->
                <div class="container">
                    <div class="row-fluid content-inner">
                        <div id="left" class="span9">
                            <!-- ADD "span12" if no sidebar, or "span9" with sidebar -->
                            <div class="wrapper ">
                                <div class="content">
                                    <div class="section article">
                                        <div class="content">
                                            <div class="img-simple span12 ">
                                                <div class="image">
                                                    <a rel="nofollow" data-ss="imagemodal"
                                                       data-href="./${mainImage}"
                                                       title="Lorem ipsum dolor sit amet"><img
                                                            src="./${mainImage}"></a>
                                                </div>
                                                <div class="image-caption">
                                                    <p class="sub2">Lorem ipsum dolor sit amet</p>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                    <div class="section">
                                        <div class="content">
                                            <ul class="thumbnails column-article-section">
                                                <c:forEach items="${listGallery}" var="gallery">
                                                <li class="span4">
                                                    <div class="img-simple span12 ">
                                                        <div class="image">
                                                            <a rel="nofollow" data-ss="imagemodal"
                                                               data-href="./${gallery.image}"><img
                                                                    src="./${gallery.image}"></a>
                                                        </div>
                                                    </div>

                                                    <h4>
                                                        <a rel="nofollow"
                                                           href="GalleryController?id=${gallery.id}">View
                                                            ${gallery.name}</a>
                                                    </h4>

                                                    <p>${gallery.content}</p>
                                                </li>
                                                </c:forEach>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="section article">
                                        <div class="heading">
                                            <h3>About me</h3>
                                        </div>

                                        <div class="content">
                                            <p><span>${contact.about}</span></p>
                                        </div>
                                    </div>
                                </div>


                            </div>
                        </div>
                        <div id="right" class="span3">
                            <div class="sidebar">
                                <div class="wrapper share-box">
                                    <div class="heading">
                                        <h4>Share this page</h4>
                                    </div>

                                    <div class="share-box-content"><span>
                                            <ul>
                                                <li><image src="./Image/face-book.jpg"/>Share on
                                                            Facebook</li>
                                                <li><image src="./Image/twister.jpg"/>Share on Twitter
                                                </li>
                                                <li><image src="./Image/google.jpg"/>Share on Google</li>
                                            </ul>
                                        </span></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div> <!-- the controller has determined which view to be shown in the content -->

            <div class="container-fluid footer-wrapper" id="footer">
                <!-- this is the Footer Wrapper -->
                <div class="container">
                    <div class="footer-info">
                        <div class="footer-powered-by">
                            <a rel="nofollow" href="Style/">Created with
                                SimpleSite</a>
                        </div>
                    </div>
                    <div class="footer-page-counters" style="display: block;">
                        <span class="footer-page-counters-item">0</span>

                        <span class="footer-page-counters-item">4</span>

                        <span class="footer-page-counters-item">4</span>

                        <span class="footer-page-counters-item">6</span>

                        <span class="footer-page-counters-item">4</span>

                        <span class="footer-page-counters-item">4</span>
                    </div>
                </div>
            </div> <!-- this is the Footer content -->
        </div>

    </body>
</html>
