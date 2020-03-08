package ${package.Controller};


import org.springframework.web.bind.annotation.RequestMapping;

<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>
    @Reference
   ${table.serviceName} ${table.entityPath}Service;
    /*添加数据*/
    @PostMapping("/save")
    public Result add(${entity} ${table.entityPath}){
        return new Result(${table.entityPath}Service.saveOrUpdate(${table.entityPath}));
    }

    /*按照id查找*/
    @GetMapping("/getone")
    public Result get${entity}ById(Integer id){
        return new Result(1, ${table.entityPath}Service.getById(id), "返回成功");
    }
    /*恢复和删除*/
    @GetMapping("/del")
    public Result del(${entity} ${table.entityPath}){
        return new Result(${table.entityPath}Service.updateById(${table.entityPath}));
    }
    @GetMapping("/list")
    public Result list(${entity} ${table.entityPath}){
        return new Result(1, ${table.entityPath}Service.page(${table.entityPath}), "成功");
    }
    @GetMapping("/query")
    public Result query(${entity} ${table.entityPath}){
        return new Result(1, ${table.entityPath}Service.list(${table.entityPath}), "成功");
    }
}
</#if>
