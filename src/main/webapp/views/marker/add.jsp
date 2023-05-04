<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    let marker_add= {
        init:function (){
            $('#register_btn').click(function (){
                marker_add.send();
            });
        },
        send:function (){
            $('#register_form').attr({
                method:'post',
                action:'/marker/addimpl',
                enctype:'multipart/form-data'
            });
            $('#register_form').submit();
        }
    };
    $(function (){
        marker_add.init();
    });
</script>
<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">marker add</h1>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">marker add</h6>
        </div>
        <div class="card-body">
            <div id="container">
                <form id="register_form" class="form-horizontal well">

                    <div class="form-group">
                        <label class="control-label col-sm-2" for="title">TITLE:</label>
                        <div class="col-sm-10">
                            <input type="text" name="title" class="form-control" id="title" placeholder="Enter title">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="target">TARGET:</label>
                        <div class="col-sm-10">
                            <input type="text" name="target" class="form-control" id="target" placeholder="Enter title">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="lat">LAT:</label>
                        <div class="col-sm-10">
                            <input type="double" name="lat" class="form-control" id="lat"
                                   placeholder="LAT">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="lng">LNG:</label>
                        <div class="col-sm-10">
                            <input type="double" name="lng" class="form-control" id="lng"
                                   placeholder="LNG">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="mimg">IMAGE:</label>
                        <div class="col-sm-10">
                            <input type="file" name="mimg" class="form-control" id="mimg"
                                   placeholder="upload image">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="loc">LOC:</label>
                        <div class="col-sm-10">
                            <input type="text" name="loc" class="form-control" id="loc" placeholder="Enter LOC">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button id="register_btn" type="button" class="btn btn-info">Register</button>
                        </div>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>
