<html title="sds" lang="zh-CN">
<!--头部 导航栏-->
<header>
    <h2>导出excel</h2>
    <link href="${request.contextPath}/webjars/bootstrap/3.0.3/dist/css/bootstrap.css" rel="stylesheet">
</header>
<hr style="filter: alpha(opacity=100,finishopacity=0,style=3)" width="80%" color="#6f5499" size="3"/>
<body class="text-center">
<form action="${request.contextPath}/bdjr/downloadExcel" method="post">
    <input type="hidden" value="generic" id="downloadClass" name="downloadClass"/>
    <input type="hidden" value="${queryStr}" id="paramStr" name="paramStr"/>
    <table class="table" align="center">
     <#list listData as da>
         <tr>
             <td>
                 <input type="text" id="col${da}" name="col${da}" class="form-control"/>
             </td>
         </tr>
     </#list>
    </table>
    <input type="submit" class="btn btn-default" value="导出excel"/>
</form>
</body>
</html>