<%@page import="Model.Usuario"%>
<%@page import="Model.Instituicao"%>
<%@page import="java.util.ArrayList"%>

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
                                     <li class="current-page">
                                        <a href="intermediario.jsp"><i class="icon-home"></i><br />Início</a>
                                    </li>
                                  
                                    <li class="current-page">
                                        <a href="instru.jsp"><i class="icon-book"></i><br />Instruções</a>
                                    </li>

                                    <li>
                                        <a href="aguarde2.jsp"><i class="icon-pencil"></i><br />Relatórios</a>
                                    </li>
                                    <li>
                                        <a href="UsuarioController?ref=listarinfo&type=1"><i class="icon-user"></i><br />Meu perfil</a>
                                    </li>
                                    <li>
                                        <a href="UsuarioController?ref=sair"><i class="icon-share-alt"></i><br />Sair</a>
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
                        <i class="icon-asterisk page-title-icon"></i>
                      <h2>Sobre você</h2>
                        <p>Altere seus dados cadastrais e veja sua pontuação.</p>
                    </div>
                </div>
            </div>
        </div>
<div class="container">
    <p>  </p>
                        <p>  </p>
</div>
  <div class="container"><div class="span12">
  
<table class="table table-striped">
            <thead>
                <tr><th><a href="UsuarioController?ref=editareu" class="btn btn-success"><i class="icon-white icon-plus"></i> Editar Informações</a></th></tr>
                <tr>
                    
                    <th>Nome</th>
                    <th>Email</th>
                    <th>Senha</th>
                    <th>Instituição</th>
                    
                </tr>
            </thead>
            <tbody>
                <%
                    Usuario jogador = (Usuario) session.getAttribute("jogador");
                    out.print("<td>"+jogador.getNom_usuario()+"</td>");
                    out.print("<td>"+jogador.getEmail_usuario()+"</td>");
                    out.print("<td>"+jogador.getSenha_usuario()+"</td>");
                    ArrayList<Instituicao> arInst = (ArrayList<Instituicao>) request.getAttribute("bdInst");
                    for(int i=0;i<arInst.size();i++){
                        if(arInst.get(i).getId_instituicao()==jogador.getInstituicao_id())
                            out.print("<td>"+arInst.get(i).getSigla_instituicao()+"</td>");
                    }
                %>
            </tbody>
</table>
</div>
</div>

        <!-- Footer -->
        <footer>
            <div class="container">
                <div class="row">
                    <div class="widget span4">
                        <h4>Sobre nós</h4>
                        <p><span class="blue">Vacina.com</span> integra conhecimentos de vacinas presentes no Calendário Nacional de Vacinação e outras que não estão representadas nele, é desenvolvido por um grupo de alunos do curso técnico de Informática no CEFET-MG, campus Divinópolis.</p>
                        <p><a href="about.jsp">Leia mais...</a></p>
                    </div>
                   

                    <div class="widget span4">
                        <h4>Entre em contato</h4>
                        <p><i class="icon-map-marker"></i> Divinópolis, MG - Brasil</p>
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

