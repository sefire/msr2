<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <style type="text/css">
        <%@include file="/bootstrap/css/bootstrap.css" %>
        <%@include file="/bootstrap/css/bootstrap-theme.css" %>
    </style>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="bootstrap/js/jquery.js"></script>
    <script src="bootstrap/js/bootstrap.js"></script>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="navbar navbar-inverse navbar-static-top"><!--убрать топ чтобы было не  -->
    <div class="container body-content">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#responsive-menu-my">
                <span class="sr-only">Открыть навигацию</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>

            </button>
            <a class="navbar-brand" href="#">Логотип</a>

        </div>
        <div class="collapse navbar-collapse" id="responsive-menu-my">
            <ul class="nav navbar-nav">
                <li><a href="#">Пункт 1</a></li>
                <li сlass="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Пункт 2<b class="caret"></b> </a>
                    <ul class="dropdown-menu">
                        <li><a href="#">п.1</a></li>
                        <li><a href="#">п.2</a></li>
                        <li><a href="#">п.3</a></li>
                        <li class="devider"> -----</li>
                        <li><a href="#">п.4</a></li>
                    </ul>
                </li>
                <li><a href="#">Пункт 3</a></li>
                <li><a href="#">Пункт 4</a></li>
            </ul>

            <form action="" class="navbar-form navbar-right" method="post">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="phone" value="">

                </div>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="password" value="">
                </div>
                <button type="submit" class="btn btn-primary">
                    <i class="fa fa-sign-in">Sign In</i>
                </button>
            </form>
        </div>
    </div>
</div>
<div id="pageheader">
    <jsp:invoke fragment="header"/>
</div>
<div id="body">
    <jsp:doBody/>
</div>
<div id="pagefooter">
    <jsp:invoke fragment="footer"/>
</div>
</body>
</html>