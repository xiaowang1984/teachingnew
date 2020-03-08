package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
@Component
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {
    @Resource
    ${table.mapperName} ${table.entityPath}Mapper;
    @Override
    public IPage<${entity}> page(${entity} ${table.entityPath}) {
        QueryWrapper<${entity}> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(${table.entityPath}.getName()))
        wrapper.like("name","%"+${table.entityPath}.getName()+"%");
        if(${table.entityPath}.getIsDel()!=null)
        wrapper.eq("is_del",${table.entityPath}.getIsDel());
        return this.page(new Page<>(${table.entityPath}.getPageNo(),${table.entityPath}.getPageSize()),wrapper);
    }
    @Override
    public List<${entity}> list(${entity} ${table.entityPath}) {
        QueryWrapper<${entity}> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(${table.entityPath}.getName()))
            wrapper.like("name", ${table.entityPath}.getName());
        if(teacher.getIsDel()!=null)
            wrapper.eq("is_del", ${table.entityPath}.getIsDel());
        return list(wrapper);
    }
}
</#if>
