<%-- 
    Document   : AltaDoctor
    Created on : 12/04/2018, 08:50:42 PM
    Author     : Unitec
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

    <title>Alta Doctor</title>

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
                <a class="navbar-brand" href="index.html">Alta Doctor</a>
            </div>
            <!-- /.navbar-header -->

           
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
                            Datos del Doctor
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form" action="../control" method="post">
                                        <input type="hidden" name="pagina" value="altaDoctor">
                                        <div class="form-group">
                                            <label>Nombre(s)</label>
                                            <input class="form-control" name="nombre"  >
                                            <p class="help-block">Ej.Uriel Manuel</p>
                                        </div>
                                        <div class="form-group">
                                            <label>Apellido Paterno</label>
                                            <input class="form-control" name="paterno">
                                            <p class="help-block">Ej.Villegas</p>
                                        </div>
                                        <div class="form-group">
                                            <label>Apellido Materno</label>
                                            <input class="form-control" name="materno">
                                            <p class="help-block">Ej.Garduño</p>
                                        </div>
                                        <div class="form-group">
                                            <label>Edad</label>
                                            <select class="form-control" name="edad" >
                                                <%
                                                    for(int i=1;i<100;i++)
                                                    {
                                                %>
                                                <option><%=i%></option>
                                                <%
                                                    }
                                                %>
                                                
                                            </select>
                                        </div>
                                        
                                        <div class="form-group">
                                            <label>E-Mail</label>
                                            <input class="form-control" name="email" type="email">
                                            <p class="form-control-static">email@example.com</p>
                                        </div>
                                        <div class="form-group">
                                            <label>Telefono</label>
                                            <input class="form-control" name="telefono" type="tel" maxlength="10"  minlength="8">
                                            <p class="help-block">10 digitos maximo</p>
                                        </div>
                                        <div class="form-group">
                                            <label>Cedula</label>
                                            <input class="form-control" name="cedula" maxlength="8" minlength="8" >
                                            <p class="help-block">8 digitos</p>
                                        </div>
                                        <div class="form-group">
                                            <label>Usuario</label>
                                            <input class="form-control" name="usuario" maxlength="8" minlength="4" >
                                            <p class="help-block"></p>
                                        </div>
                                        <div class="form-group">
                                            <label>Contraseña</label>
                                            <input class="form-control" name="contraseña" maxlength="8" minlength="4" >
                                            <p class="help-block">Minimo 4 caracteres y maximo 8</p>
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
