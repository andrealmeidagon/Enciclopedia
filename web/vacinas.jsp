<%@page import="Model.Vacina"%>
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
                                        <a href="adm.jsp"><i class="icon-home"></i><br />Início</a>
                                    </li>
                                    
                                    <li>
                                        <a href="UsuarioController?ref=listar&type=1"><i class="icon-pencil"></i><br />Editar ADM</a>
                                    </li>
                                     <li>
                                        <a href="UsuarioController?ref=listar&type=2"><i class="icon-pencil"></i><br />Editar Aluno</a>
                                    </li>
                                     <li>
                                        <a href="UfController?ref=listar"><i class="icon-pencil"></i><br />Editar Estados</a>
                                    </li>
                                     <li>
                                        <a href="CidadeController?ref=listar"><i class="icon-pencil"></i><br />Editar Cidades</a>
                                    </li>
                                     <li>
                                        <a href="InstituicaoController?ref=listar"><i class="icon-pencil"></i><br />Editar Instituições</a>
                                    </li>
                                    <li>
                                        <a href="TopicoController?ref=listar"><i class="icon-pencil"></i><br />Editar Tópicos</a>
                                    </li>
                                    <li>
                                        <a href="VacinaController?ref=listar"><i class="icon-pencil"></i><br />Editar Vacinas</a>
                                    </li>
                                    <li>
                                        <a href="DoencaController?ref=listar"><i class="icon-pencil"></i><br />Editar Doenças</a>
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
                        <i class="icon-pencil page-title-icon"></i>
                        <h2>Gerenciar Vacinas / </h2>
                        <p>Adicione, edite e exclua.</p>
                        
                    </div>
                </div>
            </div>
        </div>
<div class="container">
    <p>  </p>
                        <p>  </p>
</div>
<div class="container">
    <div class="span12">
        <table class="table table-striped">
            <thead>
                <tr><th><a href="" class="btn btn-success"><i class="icon-white icon-plus"></i> Adicionar Vacina</a></th></tr>
                <tr>
                    <th></th>
                    <th>Vacina</th>
                </tr>
            </thead>
             <tbody>
                 <%
                    if(request.getAttribute("bdVacina")!=null){
                        ArrayList<Vacina> arUf = (ArrayList<Vacina>) request.getAttribute("bdVacina");
                        for(int i=0; i<arUf.size(); i++){
                            out.print("<tr>");
                            out.print("<td><a href='VacinaController?ref=editar&id="+arUf.get(i).getId_vacina()+"' class='btn btn-primary btn-xs'> Editar</a> <title> </title><a href='VacinaController?ref=excluir&id="+arUf.get(i).getId_vacina()+"' class='btn btn-danger btn-xs'><i class='icon-remove'></i></a><title> </title> <a href='VacinaController?ref=listarsecao&id="+arUf.get(i).getId_vacina()+" type='button' class='btn btn-xs'><i class='icon-align-left'></i></a></td>");
                            out.print("<td>"+arUf.get(i).getNom_vacina()+"</td>");
                            out.print("</tr>");

                        }
                    }
                %>
            </tbody>
        </table>
    </div>
</div>

    <div class="span12">
<div class="container">
</div>
    </div>
     
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