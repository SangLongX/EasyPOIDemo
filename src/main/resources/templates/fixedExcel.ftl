<#include "indexDep.ftl">
<@html title="" lang="zh-CN">
    <header>
        <h2>常用导出的excel</h2>
    </header>
    <body class="text-center">

    <#--债转导出form-->
    <hr style="filter: alpha(opacity=100,finishopacity=0,style=3)" width="80%" color="#6f5499" size="3" />
    <div>
        <p align="left">
        <h3>债转</h3>
        </p>
        <form id="transferForm" action="/${request.contextPath}/bdjr/downloadExcel">

            <input type="hidden" class="form-control" name="downloadClass" id="downloadClass" value="transfer"/>
            <table align="center" class="table">
                <div class="form-group">
                    <tr>
                        <td>
                            <label for="item">选择平台</label>
                        </td>
                        <td align="left">
                            <select id="item" name="item">
                                <option selected="selected" value="-1">---&nbsp;&nbsp;请选择&nbsp;&nbsp;---</option>
                                <option value="0">来源1</option>
                                <option value="1">来源2</option>
                                <option value="2">来源3</option>
                            </select>
                        </td>
                    </tr>
                </div>
                <div class="form-group">
                    <tr>
                        <td>
                            <label for="userIds">用户id</label>
                        </td>
                        <td>
                            <input type="text" class="form-control" id="userIds" name="userIds"
                                   placeholder="用户id&nbsp;&nbsp;多个用逗号分隔"/>
                        </td>
                    </tr>
                </div>
                <div class="form-group">
                    <tr>
                        <td>
                            <label for="transferDate">债转开始时间</label>
                        </td>
                        <td>
                            <input type="date" class="form-control" id="transferDate" name="transferDate"/>
                        </td>
                    </tr>
                </div>
                <tr>
                    <td colspan="2">
                        <input type="submit" class="btn btn-default" value="导出结果"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>

    <hr style="filter: alpha(opacity=100,finishopacity=0,style=3)" width="80%" color="#6f5499" size="3" />
    <#--标的导出form-->
    <div>
        <p align="left">
        <h3>标的</h3>
        </p>
        <form id="loanForm" action="${request.contextPath}/bdjr/downloadExcel">
            <input type="hidden" name="downloadClass" id="downloadClass" value="loan"/>
            <table align="center" class="table">
                <tr>
                    <td>
                        <label for="longestDate">截至时间</label>
                    </td>
                    <td>
                        <input type="date" id="longestDate" name="longestDate"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" class="btn btn-default" value="导出结果"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>


    </body>
</@html>