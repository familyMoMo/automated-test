/**
 * Created by Administrator on 2015/8/29.
 */
$(document).ready(function(){
    var grid_cloNames = ['操作', 'ID', 'version', 'caseName', 'url', 'requestMethod', 'requestHeader','requestCookie',
        'requestBody', 'requestEncoding', 'contentType', 'responseResolver', 'expectResponse', 'description',
        'createTime', 'updateTime'
    ];
    var grid_selector = "#grid-table";
    var pager_selector = "#grid-pager";
    var _version = $("#form-field-select-1").val();

    $("#search").click(function () {
        _version = $("#form-field-select-1").val();
        _url = "http://localhost:9090/automated/testcase/findPageByVersion?version=" + _version;
        _caption = _version + "版本测试用例";
        _editurl = "http://localhost:9090/automated/testcase/updateTestCase?version=" + _version;
        jQuery(grid_selector).setGridParam({url:_url, editurl:_editurl, page:"1"}).setCaption(_caption).trigger("reloadGrid");
    });

    $("#create").click(function() {

    });

    $("#excute").click(function() {

    });

    jQuery(grid_selector).jqGrid({
        //url : "http://localhost:9090/automated/testcase/findPageByVersion?version=" + version + "&pageNumber="+1+"&pageSize="+ 10,
        url : "http://localhost:9090/automated/testcase/findPageByVersion?version=" + _version,
        datatype: "json",
        colNames: grid_cloNames,
        colModel: [
            {
                name: 'myac', index: '', width: 80, fixed: true, sortable: false, resize:false,
                formatter: 'actions',
                formatoptions: {
                    keys: true,
                    delOptions: {recreateForm: true, beforeShowForm: beforeDeleteCallback}
                    //editformbutton: true, editOptions: {recreateForm: true, beforeShowForm: beforeEditCallback}
                }
            },
            {name: 'id', index: 'id', editable: false},
            {name: 'version', index: 'version', editable: false, editoptions:{maxlength:50}},
            {name: 'caseName', index: 'caseName', editable: true, edittype: 'text', editoptions:{maxlength:50}, editrules: {edithidden:true,required:true}},
            {name: 'url', index: 'url', editable: true, edittype: 'text', editrules: {edithidden:true,required:true}},
            {name: 'requestMethod', index: 'requestMethod', editable: true, edittype: "select", editoptions:{value:"GET:GET;POST:POST"}},
            {name: 'requestHeader', index: 'requestHeader', editable: true, edittype: 'text'},
            {name: 'requestCookie', index: 'requestCookie', editable: true, edittype: 'text'},
            {name: 'requestBody', index: 'requestBody', editable: true, edittype: 'text'},
            {name: 'requestEncoding', index: 'requestEncoding', editable: true, edittype: "select", editoptions:{value:"UTF-8:UTF-8;GBK:GBK"}},
            {name: 'contentType', index: 'contentType', editable: true, edittype: "select", editoptions:{value:":无;application/x-www-form-urlencoded:application/x-www-form-urlencoded"}},
            {name: 'responseResolver', index: 'responseResolver', editable: true, edittype: 'select', editoptions:{value:"json:json;http-code:http-code;json-code:json-code"}},
            {name: 'expectResponse', index: 'expectResponse', editable: true, edittype: 'text', editrules: {edithidden:true,required:true}},
            {name: 'description', index: 'description', editable: true, edittype: 'text'},
            {name: 'createTime', index: 'createTime', editable: false, formatter:'date', formatoptions: {srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}},
            {name: 'updateTime', index: 'updateTime', editable: false, formatter:'date', formatoptions: {srcformat:'Y-m-d H:i:s',newformat:'Y-m-d H:i:s'}}
        ],
        viewrecords: true,
        rowNum: 10,
        rowList: [10, 20, 30],
        pager: pager_selector,
        altRows: true,
        //toppager: true,
        height: 'auto',
        multiselect: true,
        //multikey: "ctrlKey",
        multiboxonly: true,

        loadComplete: function () {
            var table = this;
            setTimeout(function () {
                styleCheckbox(table);
                updateActionIcons(table);
                updatePagerIcons(table);
                enableTooltips(table);
            }, 0);
        },

        editurl: "http://localhost:9090/automated/testcase/updateTestCase?version=" + _version,
        caption: _version + "版本测试用例",
        autowidth: true
    })

    //enable search/filter toolbar
    //jQuery(grid_selector).jqGrid('filterToolbar',{defaultSearch:true,stringResult:true})

    //switch element when editing inline
    function aceSwitch(cellvalue, options, cell) {
        setTimeout(function () {
            $(cell).find('input[type=checkbox]')
                .wrap('<label class="inline" />')
                .addClass('ace ace-switch ace-switch-5')
                .after('<span class="lbl"></span>');
        }, 0);
    }

    //enable datepicker
    function pickDate(cellvalue, options, cell) {
        setTimeout(function () {
            $(cell).find('input[type=text]')
                .datepicker({format: 'yyyy-mm-dd', autoclose: true});
        }, 0);
    }

    //navButtons
    jQuery(grid_selector).jqGrid('navGrid', pager_selector,
        { 	//navbar options
            edit: true,
            editicon: 'icon-pencil blue',
            add: true,
            addicon: 'icon-plus-sign purple',
            del: true,
            delicon: 'icon-trash red',
            search: true,
            searchicon: 'icon-search orange',
            refresh: true,
            refreshicon: 'icon-refresh green',
            view: true,
            viewicon: 'icon-zoom-in grey'
        },
        {
            //edit record form
            //closeAfterEdit: true,
            recreateForm: true,
            beforeShowForm: function (e) {
                var form = $(e[0]);
                form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
                style_edit_form(form);
            }
        },
        {
            //new record form
            closeAfterAdd: true,
            recreateForm: true,
            viewPagerButtons: false,
            beforeShowForm: function (e) {
                var form = $(e[0]);
                form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
                style_edit_form(form);
            }
        },
        {
            //delete record form
            recreateForm: true,
            beforeShowForm: function (e) {
                var form = $(e[0]);
                if (form.data('styled')) return false;

                form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
                style_delete_form(form);

                form.data('styled', true);
            },
            onClick: function (e) {
                alert(1);
            }
        },
        {
            //search form
            recreateForm: true,
            afterShowSearch: function (e) {
                var form = $(e[0]);
                form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
                style_search_form(form);
            },
            afterRedraw: function () {
                style_search_filters($(this));
            }
            ,
            multipleSearch: true
            /**
             multipleGroup:true,
             showQuery: true
             */
        },
        {
            //view record form
            recreateForm: true,
            beforeShowForm: function (e) {
                var form = $(e[0]);
                form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
            }
        }
    )


    function style_edit_form(form) {
        //enable datepicker on "sdate" field and switches for "stock" field
        form.find('input[name=sdate]').datepicker({format: 'yyyy-mm-dd', autoclose: true})
            .end().find('input[name=stock]')
            .addClass('ace ace-switch ace-switch-5').wrap('<label class="inline" />').after('<span class="lbl"></span>');

        //update buttons classes
        var buttons = form.next().find('.EditButton .fm-button');
        buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();//ui-icon, s-icon
        buttons.eq(0).addClass('btn-primary').prepend('<i class="icon-ok"></i>');
        buttons.eq(1).prepend('<i class="icon-remove"></i>')

        buttons = form.next().find('.navButton a');
        buttons.find('.ui-icon').remove();
        buttons.eq(0).append('<i class="icon-chevron-left"></i>');
        buttons.eq(1).append('<i class="icon-chevron-right"></i>');
    }

    function style_delete_form(form) {
        var buttons = form.next().find('.EditButton .fm-button');
        buttons.addClass('btn btn-sm').find('[class*="-icon"]').remove();//ui-icon, s-icon
        buttons.eq(0).addClass('btn-danger').prepend('<i class="icon-trash"></i>');
        buttons.eq(1).prepend('<i class="icon-remove"></i>')
    }

    function style_search_filters(form) {
        form.find('.delete-rule').val('X');
        form.find('.add-rule').addClass('btn btn-xs btn-primary');
        form.find('.add-group').addClass('btn btn-xs btn-success');
        form.find('.delete-group').addClass('btn btn-xs btn-danger');
    }

    function style_search_form(form) {
        var dialog = form.closest('.ui-jqdialog');
        var buttons = dialog.find('.EditTable')
        buttons.find('.EditButton a[id*="_reset"]').addClass('btn btn-sm btn-info').find('.ui-icon').attr('class', 'icon-retweet');
        buttons.find('.EditButton a[id*="_query"]').addClass('btn btn-sm btn-inverse').find('.ui-icon').attr('class', 'icon-comment-alt');
        buttons.find('.EditButton a[id*="_search"]').addClass('btn btn-sm btn-purple').find('.ui-icon').attr('class', 'icon-search');
    }

    function beforeDeleteCallback(e) {
        var form = $(e[0]);
        if (form.data('styled')) return false;

        form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
        style_delete_form(form);

        form.data('styled', true);
    }

    function beforeEditCallback(e) {
        var form = $(e[0]);
        form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
        style_edit_form(form);
    }


    //it causes some flicker when reloading or navigating grid
    //it may be possible to have some custom formatter to do this as the grid is being created to prevent this
    //or go back to default browser checkbox styles for the grid
    function styleCheckbox(table) {
        /**
         $(table).find('input:checkbox').addClass('ace')
         .wrap('<label />')
         .after('<span class="lbl align-top" />')


         $('.ui-jqgrid-labels th[id*="_cb"]:first-child')
         .find('input.cbox[type=checkbox]').addClass('ace')
         .wrap('<label />').after('<span class="lbl align-top" />');
         */
    }


    //unlike navButtons icons, action icons in rows seem to be hard-coded
    //you can change them like this in here if you want
    function updateActionIcons(table) {
        /**
         var replacement =
         {
             'ui-icon-pencil' : 'icon-pencil blue',
             'ui-icon-trash' : 'icon-trash red',
             'ui-icon-disk' : 'icon-ok green',
             'ui-icon-cancel' : 'icon-remove red'
         };
         $(table).find('.ui-pg-div span.ui-icon').each(function(){
						var icon = $(this);
						var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
						if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
					})
         */
    }

    //replace icons with FontAwesome icons like above
    function updatePagerIcons(table) {
        var replacement =
        {
            'ui-icon-seek-first': 'icon-double-angle-left bigger-140',
            'ui-icon-seek-prev': 'icon-angle-left bigger-140',
            'ui-icon-seek-next': 'icon-angle-right bigger-140',
            'ui-icon-seek-end': 'icon-double-angle-right bigger-140'
        };
        $('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function () {
            var icon = $(this);
            var $class = $.trim(icon.attr('class').replace('ui-icon', ''));

            if ($class in replacement) icon.attr('class', 'ui-icon ' + replacement[$class]);
        })
    }

    function enableTooltips(table) {
        $('.navtable .ui-pg-button').tooltip({container: 'body'});
        $(table).find('.ui-pg-div').tooltip({container: 'body'});
    }

});