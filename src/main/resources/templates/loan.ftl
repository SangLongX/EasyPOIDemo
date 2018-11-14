<#include "indexDep.ftl">
<@html title="" lang="zh-CN">
    <!--头部 导航栏-->
    <header>
        <h2>下载标的excel</h2>
    </header>
    <body class="text-center">

    <form action="/bdjr/downloadExcel">
        <input type="hidden" name="downloadClass" id="downloadClass" value="loan"/>
        <div class="row">
            <label class="text-left">截至时间</label>
            <input type="date" id="longestDate" name="longestDate"/>
        </div>


        <input type="submit" value="导出结果"/>
    </form>

    </body>
</@html>