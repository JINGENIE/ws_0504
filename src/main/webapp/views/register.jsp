<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>

    let register_form = {
        init:function(){
            $('#register_btn').addClass('disabled');
            $('#register_btn').click(function(){
                register_form.send();
            });
            $('#lev').keyup(function (){
                var id = $('#id').val();
                var pwd = $('#pwd').val();
                var lev = $('#lev').val();
                if(id != ''&& pwd != ''&& lev != ''){
                    $('#register_btn').removeClass('disabled');
                }
            })
            $('#id').keyup(function (){
                $('#register_btn').addClass('disabled');
                var txt_id= $(this).val();
                if(txt_id.length<=3){
                    return;
                }
                $.ajax({
                    url:'/checkid',
                    data:{'id':txt_id},
                    success:function(result){
                        if(result == 0){
                            $('#check_id').text('사용가능합니다.');
                            $('#pwd').focus();
                        }else{
                            $('#check_id').text('사용불가능합니다.');
                        }
                    }
                });
            });
        },
        send:function(){
            var id = $('#id').val();
            var pwd = $('#pwd').val();
            var lev = $('#lev').val();
            if(id.length<=3){
                $('#check_id').text('4자리이상 입력하세요');
                $('#id').focus();
                return;
            }
            if(pwd == ''){
                $('#pwd').focus();
                return;
            }
            if(lev == ''){
                $('#lev').focus();
                return;
            }
            $('#register_form').attr({
                'action':'/registerimpl',
                'method':'post'
            });
            $('#register_form').submit();
        }
    };


    $(function(){
        register_form.init();
    });
</script>
<!-- Begin Page Content -->
<div class="container-fluid">
    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Register</h1>
    <div class="col-sm-8 text-left">
        <div class="container">
            <div class="row content">
                <div class="col-sm-8  text-left ">
                    <form id="register_form" class="form-horizontal well">
                        <div class="form-group">
                            <label class="control-label col-sm-6" for="id">ID:</label>
                            <div class="col-sm-10">
                                <input type="text" name="id" class="form-control" id="id" placeholder="Enter id">
                            </div>
                        </div>
                        <div>
                            <span id="check_id" class="bg-danger"></span>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-6" for="pwd">Password:</label>
                            <div class="col-sm-10">
                                <input type="password" name="pwd" class="form-control" id="pwd" placeholder="Enter password">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-6" for="lev">NAME:</label>
                            <div class="col-sm-10">
                                <input type="text" name="lev" class="form-control" id="lev" placeholder="Enter name">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button id="register_btn" type="button" class="btn btn-default">Register</button>
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