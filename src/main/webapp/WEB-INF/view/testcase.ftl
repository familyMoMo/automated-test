<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link href="../assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="../assets/css/font-awesome.min.css" rel="stylesheet">
    <link href="../assets/css/ui.jqgrid.css" rel="stylesheet">
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />
    <link href="../assets/css/ace.min.css" rel="stylesheet">
</head>
<body>
<div class="navbar navbar-default" id="navbar">
    <div class="navbar-container" id="navbar-container">
        <div class="navbar-header pull-left">
            <a href="#" class="navbar-brand">
                <small>
                    <i class="icon-leaf"></i>
                    WEB自动化测试
                </small>
            </a><!-- /.brand -->
        </div><!-- /.navbar-header -->

        <!-- /.navbar-header -->
    </div><!-- /.container -->
</div>
<div class="main-container" id="main-container">
    <div class="sidebar" id="sidebar">
        <ul class="nav nav-list">
            <li class="active open">
                <a href="#" class="dropdown-toggle">
                    <i class="icon-list"></i>
                    <span class="menu-text"> 自动化测试</span>

                    <b class="arrow icon-angle-down"></b>
                </a>
                <ul class="submenu">
                    <li class="active">
                        <a href="http://localhost:9090/automated/testcase/index">
                            <i class="icon-double-angle-right"></i>
                            测试用例
                        </a>
                    </li>
                    <li>
                        <a href="http://localhost:9090/automated/testcase/testResult">
                            <i class="icon-double-angle-right"></i>
                            测试结果
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
        <div class="sidebar-collapse" id="sidebar-collapse">
            <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
        </div>
    </div>
    <div class="main-content">
        <div class="breadcrumbs" id="breadcrumbs">
            <ul class="breadcrumb">
                <li>
                    <i class="icon-home home-icon"></i>
                    <a href="grid.html">主页</a>
                </li>

                <li>
                    <a href="grid.html">自动化测试用例</a>
                </li>
                <li class="active">测试用例</li>
            </ul>
        </div>
        <div class="page-content">
            <div class="page-header">
                <form class="form-inline">
                    <div class="form-group">
                        <label class="col-sm-4 control-label no-padding-right" for="form-field-select-1">用例版本</label>
                        <div class="col-sm-8">
                            <select class="form-control" id="form-field-select-1">
                                <#list versions as version>
                                    <option id="${version.version}">${version.version}</option>
                                </#list>
                            </select>
                        </div>
                    </div>
                    <button id="search" type="button" class="btn btn-purple btn-sm">查询<i class="icon-search icon-on-right bigger-110"></i></button>
                    <button id="create" type="button" class="btn btn-purple btn-sm">创建新版本<i class=" icon-plus-sign-alt icon-on-right bigger-110"></i></button>
                    <button id="excute" type="button" class="btn btn-purple btn-sm">执行该版本用例<i class=" icon-play icon-on-right bigger-110"></i></button>
                </form>
            </div>
            <div class="row">
                <div class="col-xs-12">
                    <!-- PAGE CONTENT BEGINS -->

                    <div class="alert alert-danger" style="display: none">
                        <i class="icon-hand-right"></i>
                        错误提示
                        <button class="close" data-dismiss="alert">
                            <i class="icon-remove"></i>
                        </button>
                    </div>
                    <table id="grid-table"></table>
                    <div id="grid-pager"></div>
                </div>
                <script type="text/javascript">
                    var $path_base = "/";//this will be used in gritter alerts containing images
                </script>
                <!-- PAGE CONTENT ENDS -->
            </div><!-- /.col -->
        </div><!-- /.row -->
        <div id="versionwrap">
            <form id="versionform" role="form" method="post" action="http://localhost:9090/automated/testcase/addVersion">
                <div class="form-group">
                    <label for="version">Version</label>
                    <input type="version" class="form-control"
                           id="version" name="version">
                </div>
            </form>
        </div>
        <div id="tagnamewrap">
            <form id="tagnameform" role="form" method="post" action="http://localhost:9090/automated/testcase/excuteTestCase">
                <div class="form-group">
                    <label for="tagName">Tag Name</label>
                    <input type="text" class="form-control"
                           id="tagName" name="tagName">
                    <label for="hideVersion" style="display: none">Version</label>
                    <input type="text" class="form-control" id="hideVersion" name="hideVersion" style="display: none">
                </div>
            </form>
        </div>
    </div>
</div>
</div>
<script src="../assets/js/jquery-2.0.3.min.js"></script>
<script src="../assets/js/bootstrap.min.js"></script>
<script src="../assets/js/jqGrid/jquery.jqGrid.min.js"></script>
<script src="../assets/js/jqGrid/i18n/grid.locale-en.js"></script>
<script src="../assets/js/date-time/bootstrap-datepicker.min.js"></script>
<script src="../assets/js/ace.min.js"></script>
<script src="../assets/js/ace-extra.min.js"></script>
<script src="../assets/js/jquery.bootstrap.min.js"></script>

<script src="../assets/js/automated-test/index.js"></script>
</body>
</html>