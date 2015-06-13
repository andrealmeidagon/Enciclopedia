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
                                        <a href="adm.jsp"><i class="icon-home"></i><br />In�cio</a>
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
                                        <a href="InstituicaoController?ref=listar"><i class="icon-pencil"></i><br />Editar Institui��es</a>
                                    </li>
                                    
                                    <li>
                                        <a href="TopicoController?ref=listar"><i class="icon-pencil"></i><br />Editar T�picos</a>
                                    </li>
                                    <li>
                                        <a href="VacinaController?ref=listar"><i class="icon-pencil"></i><br />Editar Vacinas</a>
                                    </li>
                                    <li>
                                        <a href="DoencaController?ref=listar"><i class="icon-pencil"></i><br />Editar Doen�as</a>
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
                        <h2>Editar Aluno / </h2>
                        <p>Preencha corretamente os campos abaixo.</p>
                        
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <p>  </p>
                                <p>  </p>
        </div>

        <form role="form" action="UsuarioController?id=<%=request.getParameter("id")%>&type=2" method="post">
                <div class="form-group">
                     <label for="exampleInputEmail1">Nome* </label><input type="text" class="form-control" id="exampleInputEmail1" />
                </div>
                <div class="form-group">
                     <label for="exampleInputPassword1">Senha*</label><input type="password" class="form-control" id="exampleInputPassword1" />
                </div>
                <div class="form-group">
                     <label for="exampleInputPassword1">Institui��o</label>
                    <div class="btn-group">
                        <select class="selectpicker" name="instituicao_id">
                            <%
                                if(request.getAttribute("bdInst") != null){ 
                                    ArrayList<Instituicao> arRet = (ArrayList<Instituicao>) request.getAttribute("bdInst");
                                    for(int i=0; i<arRet.size(); i++){
                                        out.print("<option value='" + arRet.get(i).getId_instituicao()+ "'>" + arRet.get(i).getSigla_instituicao()+ "</option>");
                                    }
                                }
                            %>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                     <label for="exampleInputPassword1">Email*</label><input type="email" class="form-control" id="exampleInputEmail1" />
                </div>
                        
                        Os campos com * devem ser obrigatoriamente preenchidos.
                    
                    </p>
                </div>
                <input type="submit" class="btn btn-danger btn-large" name="ref" value="Alterar"> 
            </form>
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
