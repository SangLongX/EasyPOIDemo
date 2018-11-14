<#include "indexDep.ftl">
<@html title="" lang="zh-CN">
    <!--头部 导航栏-->
    <header>
        <h2>下载债转excel</h2>
    </header>
    <body class="text-center">
        <form action="/bdjr/downloadExcel">
            <div class="form-group">
                <input type="hidden" class="form-control" name="downloadClass" id="downloadClass" value="transfer"/>

                <label class="text-left"><mark>排除该数据源</mark></label>
                <select id="item" name="item">
                    <option selected="selected" value="-1">---&nbsp;&nbsp;请选择&nbsp;&nbsp;---</option>
                    <option value="0">百达</option>
                    <option value="1">富管家</option>
                    <option value="2">同城</option>
                </select>
            </div>

            <div class="form-group">
                <label class="text-left"><mark>排除该用户</mark></label>
                <input type="text" class="form-control" id="userIds" name="userIds" placeholder="排除用户id&nbsp;多个用逗号分隔"/>
            </div>
            <div class="form-group">
                <label class="text-left">债转开始时间</label>
                <input type="date" class="form-control" id="transferDate" name="transferDate"/>
            </div>
                <input type="submit" value="导出结果"/>

        </form>
    </body>
</@html>