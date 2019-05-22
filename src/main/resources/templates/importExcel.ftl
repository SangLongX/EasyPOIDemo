<#include "indexDep.ftl">
<@html title="" lang="zh-CN">
    <header>
        <h2>导入excel</h2>
    </header>
    <body class="text-center">

    <form method="post" action="${request.contextPath}/importExcel2" enctype="multipart/form-data">
        <input name="excelFile" type="file"/>

        <input type="submit" value="导入"/>
        <input type="reset" value="重置"/>
    </form>

    </body>
</@html>