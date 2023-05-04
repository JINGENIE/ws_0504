<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
    $(function(){
        login_form.init();
    });
</script>

<!-- Begin Page Content -->
<div class="container-fluid">
    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Login</h1>
    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Login</h6>
        </div>
        <div class="card-body">
            <div class="col-sm-8  text-left ">
                <div class="container">
                    <div class="row content">
                        <div class="col-sm-6  text-left ">

                            <form id="login_form" class="form-horizontal well">
                                <div class="form-group">
                                    <label class="control-label col-sm-8" for="id">ID:</label>
                                    <div class="col-sm-50">
                                        <input type="text" name="id" class="form-control" id="id" placeholder="Enter id">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-8" for="pwd">Password:</label>
                                    <div class="col-sm-50">
                                        <input type="password" name="pwd" class="form-control" id="pwd" placeholder="Enter password">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-offset-2 col-sm-10">
                                        <button id="login_btn" type="button" class="btn btn-default">LOGIN</button>
                                    </div>
                                </div>
                            </form>

                        </div>
                    </div>
                </div>
            </div>



    </div>

</div>
</div>
<!-- /.container-fluid -->