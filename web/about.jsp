
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

        <!-- Header -->
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
                                    <%
                                        if(session.getAttribute("admin")!=null){
                                    %>
                            
                                    <li class="current-page">
                                       <a href="adm.jsp"><i class="icon-home"></i><br />In�cio</a>
                                    </li>
                                  
                                    <li>
                                        <a href="editar.jsp"><i class="icon-pencil"></i><br />Editar ADM</a>
                                    </li>
                                    <li>
                                        <a href="editaraluno.jsp"><i class="icon-pencil"></i><br />Editar Aluno</a>
                                    </li>
                                    <li>
                                        <a href="editarestados.jsp"><i class="icon-pencil"></i><br />Editar Estados</a>
                                    </li>
                                     <li>
                                        <a href="editarcidades.jsp"><i class="icon-pencil"></i><br />Editar Cidades</a>
                                    </li>
                                     <li>
                                        <a href="editarinstituicoes.jsp"><i class="icon-pencil"></i><br />Editar Institui��es</a>
                                    </li>
                                    <li>
                                        <a href="UsuarioController?ref=sair"><i class="icon-share-alt"></i><br />Sair</a>
                                    </li>
                                    
                                    <%
                                        }else if(session.getAttribute("jogador")!=null){
                                    %>
                                    
                                    <li class="current-page">
                                        <a href="intermediario.jsp"><i class="icon-home"></i><br />In�cio</a>
                                    </li>

                                    <li>
                                        <a href="about2.jsp"><i class="icon-comments"></i><br />Sobre</a>
                                    </li>
                                       <li>
                                        <a href="UsuarioController?ref=sair"><i class="icon-share-alt"></i><br />Sair</a>
                                    </li>
                                    
                                    <%
                                        }else{
                                    %>
                                    
                                    <li class="current-page">
                                        <a href="index.jsp"><i class="icon-home"></i><br />In�cio</a>
                                    </li>

                                    <li>
                                        <a href="UsuarioController?ref=listarinst"><i class="icon-pencil"></i><br />Registrar</a>
                                    </li>
                                    <li>
                                        <a href="about.jsp"><i class="icon-comments"></i><br />Sobre</a>
                                    </li>
                                    
                                    <%
                                        }
                                    %>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Page Title -->
        <div class="page-title">
            <div class="container">
                <div class="row">
                    <div class="span12">
                        <i class="icon-comments page-title-icon"></i>
                        <h2>Sobre /</h2>
                        <p>Abaixo voc� encontra informa��es sobre o trabalho e os desenvolvedores</p>
                    </div>
                </div>
            </div>
        </div>

        <!-- About Us Text -->
        <div class="about-us container">
            <div class="row">
                <div class="about-us-text span12">
                   
                    <p>A medicina vem evoluindo muito ao longo do tempo. Ap�s o surgimento das vacinas, a humanidade vem vivenciando uma era de cuidados e preven��o �s doen�as, por�m, estas ainda s�o uma amea�a � vida humana. 
                    Atualmente, muitas doen�as s�o vacin�veis e, portanto, preven�veis. Apesar deste fato, constata-se uma defici�ncia muito grande com rela��o ao aprendizado da aplica��o das vacinas pelos profissionais especializados, que deveria acontecer como prioridade nos cursos, pois a complexidade deste ato o torna muito importante. Pensando nisso, a professora Doutora Let�cia Helena Janu�rio, juntamente do professor Mestre Daniel Morais dos Reis, prop�s ao PIBIC-Jr um projeto chamado  <span class="blue">Vacina.com</span> que culminou nesse software. <span class="blue">Vacina.com</span> integra conhecimentos de vacinas presentes no Calend�rio Nacional de Vacina��o e outras que n�o est�o representadas nele, � desenvolvido por um grupo de alunos do curso t�cnico de Inform�tica no CEFET-MG, campus Divin�polis. O objetivo principal � auxiliar e complementar os estudos dos alunos do curso enfermagem, proporcionando uma forma interativa de aprendizado.</p>
                    
                </div>
            </div>
        </div>

       

        <!-- Desenvolvedores -->
        <div class="testimonials container">
            <div class="testimonials-title">
                <h3>Desenvolvedores</h3>
            </div>
            <div class="row">
                <div class="testimonial-list span12">
                    <div class="tabbable tabs-below">
                        <div class="tab-content">
                            <div class="tab-pane active" id="A">
                            <img width="150px" height="150px" src="img/nat.jpg"/>
                                 <div align="center"> <p>Nath�lia Cristian Ferreira de Oliveira, 17 anos. Aluna do 2� ano do curso de Inform�tica no CEFET-MG, campus Divin�polis.  </p> </div>
                            </div>
                            <div class="tab-pane" id="B">
                               <img width="150px" height="150px" src="img/ju.jpg"/> 
                                <div align="center"> <p>J�lia Elias Morato, 17 anos. Aluna do 2� ano do curso de Inform�tica no CEFET-MG, campus Divin�polis.</p></div>
                            </div>
                            <div class="tab-pane" id="C">
                               <img width="150px" height="150px" src="img/andre.jpg"/> 
                                 <div align="center"><p>Andr� Almeida Gon�alves, 16 anos. Aluno do 2� ano do curso de Inform�tica no CEFET-MG, campus Divin�polis. </p></div>
                            </div>
                            <div class="tab-pane" id="D">
                               <img width="150px" height="150px" src="img/paula.jpg"/> 
                                 <div align="center"><p>Paula Gon�alves. Aluna do 6� periodo do curso de Enfermagem na UFSJ, campus Divin�polis. </p></div>
                            </div>
                            <div class="tab-pane" id="E">
                               <img src="assets/img/testimonials/1.jpg" title="" alt=""> 
                                 <div align="center"><p>Doutora Let�cia Helena Janu�rio, professora na UFSJ, campus Divin�polis. </p></div>
                            </div>
                             <div class="tab-pane" id="F">
                                <img src="img/daniel.jpg" title="" alt="">
                                 <div align="center"><p>Mestre Daniel Morais dos Reis, professor no CEFET-MG, campus Divin�polis.</p> </div>
                            </div>
                        </div>
                       <ul class="nav nav-tabs">
                           <li class="active"><a href="#A" data-toggle="tab"></a></li>
                           <li class=""><a href="#B" data-toggle="tab"></a></li>
                           <li class=""><a href="#C" data-toggle="tab"></a></li>
                           <li class=""><a href="#D" data-toggle="tab"></a></li>
                           <li class=""><a href="#E" data-toggle="tab"></a></li>
                           <li class=""><a href="#F" data-toggle="tab"></a></li>
                       </ul>
                   </div>
                </div>
            </div>
        </div>

         <!-- Footer -->
        <footer>
            <div class="container">
                <div class="row">
                    <div class="widget span4">
                        <h4>Sobre n�s</h4>
                        <p><span class="blue">Vacina.com</span> integra conhecimentos de vacinas presentes no Calend�rio Nacional de Vacina��o e outras que n�o est�o representadas nele, � desenvolvido por um grupo de alunos do curso t�cnico de Inform�tica no CEFET-MG, campus Divin�polis.</p>
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

