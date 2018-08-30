<#import "parts/common.ftl" as c>
<@c.page>
<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
   aria-controls="collapseExample">
    Add new Message
</a>
<div class="collapse" id="collapseExample">
    <div class="form-group mt-3">
        <form method="post" enctype="multipart/form-data">
            <div class="form-group">
                <input type="text" class="form-control" name="text" placeholder="Введите сообщение"/>
            </div>
            <div class="form-group">
                <div class="custom-file">
                    <input type="file" name="file" id="customFile">
                    <label class="custom-file-label" for="customFile">Choose file</label>
                </div>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Добавить</button>
            </div>
        </form>
    </div>
</div>

<div class="card-columns">
    <#list messages as message>
        <div class="card my-3">
        <#if message.getMessage()??>
            <#list message.getImages() as image>
                  <img class="card-img-top" src="img/${image.getName()}">
            </#list>
            <div class="m-2">
                <span>${message.getMessage()}</span>
            </div>
            <div class="card-footer text-muted">
                ${message.getId()}
            </div>
        </#if>
        </div>
    <#else>
        No message
    </#list>
</div>
</@c.page>