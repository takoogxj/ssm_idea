<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/3/12 0012
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品分类</title>
</head>
<body>
    <%--用自己的数据载入树形书--%>
    <ul id="productCategory" class="easyui-tree"></ul>

    <div id="mm" class="easyui-menu" style="width:120px;">
        <div onclick="append()" data-options="iconCls:'icon-add'">添加</div>
        <div onclick="rename()" data-options="iconCls:'icon-add'">修改</div>
        <div onclick="remove()" data-options="iconCls:'icon-remove'">删除</div>
    </div>

<script type="text/javascript">


    $(function(){

        $('#productCategory').tree({
            url: "/product_category/list",

            onContextMenu: function(e, node){
                e.preventDefault();
                // select the node
                $('#productCategory').tree('select', node.target);
                // display context menu
                $('#mm').menu('show', {
                    left: e.pageX,
                    top: e.pageY
                });
            },

            onAfterEdit: function(node){

                var _tree = $('#productCategory');

                if(node.id==0){
                    //添加操作
                    $.post("/product_category/add",
                        {
                            name: node.text,
                            parentId: node.parentId
                        },
                        function(data){
                            if(data.status==200){
                                _tree.tree('update',{
                                    target: node.target,
                                    id:data.msg
                                });

                            }else {
                                $.messager.alert("添加分类失败");
                            }
                        });
                }else {
                    //修改操作

                }
            }

        });

    })

    function append(){

        var tree = $('#productCategory');

        var node = tree.tree('getSelected');

        tree.tree('append', {
            parent: (node?node.target:null),
            data: [{
                id: 0,  //新建节点id=0
                parentId: node.id,
                text: '新建分类'
            }]
        });

        var _node = tree.tree('find',0);//此处0为新建节点修改
        tree.tree('select',_node.target).tree('beginEdit',_node.target);
    }

    function rename(){
        var tree = $('#productCategory');

        var node = tree.tree('getSelected');

        tree.tree('beginEdit',node.target);
    }

    function remove(){
        var tree = $('#productCategory');

        var node = tree.tree('getSelected');

        $.post("/product_category/del",
            {
                id: node.id,
                parentId: node.attributes
            },
            function(data){
                if(data.status==200){
                    tree.tree('remove',node.target);

                }else {
                    $.messager.alert("删除分类失败");
                }
            });

    }

</script>
</body>
</html>
