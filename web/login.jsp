<!DOCTYPE html>
<html>

    <head>

        <meta charset="utf-8">
        <title>Vacina.com</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,400">
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Droid+Sans">
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lobster">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/prettyPhoto/css/prettyPhoto.css">
        <link rel="stylesheet" href="assets/css/flexslider.css">
        <link rel="stylesheet" href="assets/css/font-awesome.css">
        <link rel="stylesheet" href="assets/css/style.css">
            <link rel="icon" type="image/png" href="pag.png" > 

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->



    </head>

    <body>

       
        <div class="container">
            <div class="header row">
                <div class="span12">
                    <div class="navbar">
                        <div class="navbar-inner">
                            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </a>
                            
                            <div class="nav-collapse collapse">
                                <ul class="nav pull-right">
                                    <li class="current-page">
                                        <a href="index.jsp"><i class="icon-home"></i><br />Inicio</a>
                                    </li>

                                    <li>
                                        <a href="UsuarioController?ref=listarinst&type=2"><i class="icon-pencil"></i><br />Registrar</a>
                                    </li>
                                    <li>
                                        <a href="about.jsp"><i class="icon-comments"></i><br />Sobre</a>
                                    </li>
                                    
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

<div class="page-title">
            <div class="container">
                <div class="row">
                    <div class="span12">
                        <i class="icon-check page-title-icon"></i>
                        <h2>Entrar /</h2>
                        <p>Tenha acesso aos m�dulos do <span class="blue">Vacina.com</span></p>
                        
                    </div>
                </div>
            </div>
        </div>


<div class="tabbable"> 
  
        <div class="span12">
 
            <form role="form" method="post" action="UsuarioController">
                 <div class="form-group">
                      <label for="exampleInputEmail1">Login </label><input name="login" type="email" class="form-control" id="exampleInputEmail1" />
                </div>
                <div class="form-group">
                        <label for="exampleInputPassword1">Senha</label><input name="senha" type="password" class="form-control" id="exampleInputPassword1" />
                </div>
                <input type="submit" class="btn btn-danger btn-large" name="ref" value="Entrar">
            </form>


    </div>
</div>
    

      


           
        <!-- Footer -->
        <footer>
            <div class="container">
                <div class="row">
                    <div class="widget span4">
                        <h4>Sobre n�s</h4>
                        <p><span class="blue">Vacina.com</span> integra conhecimentos de vacinas presentes no Calend�rio Nacional de Vacina��o, � desenvolvido por um grupo de alunos do curso t�cnico de Inform�tica no CEFET-MG, campus Divin�polis.</p>
                        <p><a href="about.jsp">Leia mais...</a></p>
                    </div>
                   

                    <div class="widget span4">
                        <h4>Entre em contato</h4>
                        <p><i class="icon-map-marker"></i> Divin�polis, MG - Brasil</p>
                        <p><i class="icon-envelope-alt"></i> Email: <a href="">vacinapontocom@gmail.com</a></p>
                    </div>  
                    <div class="widget span4">
                        <div align ="center">
                        <img   width="100px" height="100px" src= "logocefet.png">
                   </div>
                        
                    </div>
                    <div class ="widget span4">
                        <div align="center">
                            <img   width="100px" height="100px" src= "ufsj.png">
                        </div>
                    </div>
                </div>
                <div class="footer-border"></div>
                
            </div>
        </footer>

        <!-- Javascript -->
        <script src="assets/js/jquery-1.8.2.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.flexslider.js"></script>
        <script src="assets/js/jquery.tweet.js"></script>
        <script src="assets/js/jflickrfeed.js"></script>
        <script src="http://maps.google.com/maps/api/js?sensor=true"></script>
        <script src="assets/js/jquery.ui.map.min.js"></script>
        <script src="assets/js/jquery.quicksand.js"></script>
        <script src="assets/prettyPhoto/js/jquery.prettyPhoto.js"></script>
        <script src="assets/js/scripts.js"></script>

    </body>

</html>

