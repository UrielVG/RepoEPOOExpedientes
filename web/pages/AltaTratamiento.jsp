<%-- 
    Document   : AltaTratamiento
    Created on : 14/04/2018, 01:45:04 PM
    Author     : Uriel Villegas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Tratamiento</title>

    <!-- Bootstrap Core CSS -->
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="../vendor/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    </head>
    <body>
        <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Nuevo Tratamiento</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">

                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Cerrar sesión</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="#"><i class="fa fa-table fa-fw"></i> Consulta<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                
                                <li>
                                    <a href="ConsultaPaciente.jsp"> Paciente</a>
                                </li>
                                <li>
                                    <a href="ConsultaMedicina.jsp"> Medicinas</a>
                                </li>
                                <li>
                                    <a href="ConsultaDoctor.jsp"> Doctor</a>
                                </li>
                                <li>
                                    <a href="ConsultaDiagnostico.jsp"> Diagnosticos</a>
                                </li>
                                <li>
                                    <a href="ConsultaTratamiento.jsp"> Tratamiento</a>
                                </li>
                                <li>
                                    <a href="ConsultaReceta.jsp">Recetas</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-edit fa-fw"></i> Altas <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                
                                <li>
                                    <a href="AltaPaciente.jsp"> Paciente</a>
                                </li>
                                <li>
                                    <a href="AltaMedicamento.jsp"> Medicina </a>
                                </li>
                                <li>
                                    <a href="AltaDoctor.jsp"> Doctor</a>
                                </li>
                                <li>
                                    <a href="AltaDiagnostico.jsp"> Diagnosticos</a>
                                </li>
                                <li>
                                    <a href="AltaTratamiento.jsp"> Tratamiento </a>
                                </li>
                                <li>
                                    <a href="AltaConsulta.jsp"> Consulta </a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
        
        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Forms</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Nuevo Tratamiento
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form" action="../control" method="post">
                                        <input type="hidden" name="pagina" value="altaTratamiento">
                                        
                                        
                                        <div class="form-group">
                                            <%@page import="Dao.*"  %>
                                            <%@page import="java.util.ArrayList" %>
                                            <label>Medicamento</label>
                                            <select class="form-control" name="medicamento" >
                                                <%
                                                    ArrayList<Medicamento> med=new ArrayList();
                                                    MedicamentoDao md=new MedicamentoDao();
                                                    med=md.consulta();
                                                    for(Medicamento m:med)
                                                    {
                                                %>
                                                <option><%=m.getNombre%></option>
                                                <%
                                                    }
                                                %>
                                                
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <%@page import="Dao.*"  %>
                                            <%@page import="java.util.ArrayList" %>
                                            <label>Diagnostico</label>
                                            <select class="form-control" name="diagnostico" >
                                                <%
                                                    ArrayList<Diagnostico> dia=new ArrayList();
                                                    DiagnosticoDao dd=new DiagnosticoDao();
                                                    dia=dd.consulta();
                                                    for(Diagnostico d:dia)
                                                    {
                                                %>
                                                <option><%=d.getNombre%></option>
                                                <%
                                                    }
                                                %>
                                                
                                            </select>
                                        </div>
                                        
                                        
                                        <button type="submit" class="btn btn-default">Aceptar</button>
                                        <button type="reset" class="btn btn-default">Borrar Todo</button>
                                        
                                    </form>
                                </div>
                                <!-- /.col-lg-6 (nested) -->
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="../vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>
    </body>
</html>
