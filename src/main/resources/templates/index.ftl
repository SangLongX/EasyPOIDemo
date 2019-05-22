<!DOCTYPE html>
<html lang="zh-CN">
<head name="viewport" content="width=device-width, initial-scale=1">
    <title>admin</title>
    <link href="${request.contextPath}/webjars/bootstrap/3.0.3/dist/css/bootstrap.css" rel="stylesheet">
</head>

    <body>
        <h3 align="center">excel导出功能</h3>
        <br/>
        <hr/>
        <ul class="list-unstyled">
            <li>
                <a href="${request.contextPath}/excel/fixed">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;标的和债转导出</a>
            </li>
            <li>
                <a href="${request.contextPath}/excel/generic">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;通用导出</a>
            </li>
            <li>
                <a href="${request.contextPath}/excel/import">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;导入</a>
            </li>

        </ul>

    </body>

</html>