<html title="sds" lang="zh-CN">
    <!--头部 导航栏-->
    <header>
        <h2>选择excel</h2>
        <link href="${request.contextPath}/webjars/bootstrap/3.0.3/dist/css/bootstrap.css" rel="stylesheet">
    </header>
    <hr style="filter: alpha(opacity=100,finishopacity=0,style=3)" width="80%" color="#6f5499" size="3" />
    <body class="text-center">
        <form action="${request.contextPath}/bdjr/excel/genericExport">
            <select id="sql" name="sql" class="form-control">
                <option selected="selected" value="">---&nbsp;&nbsp;请选择&nbsp;&nbsp;---</option>
                <#list selectItems as item>
                    <option value=${item.abbr}>${item.cnDes}</option>
                </#list>
            </select>

            <input class="btn btn-default" type="submit" value="生成查询内容"/>
        </form>
    </body>
</html>