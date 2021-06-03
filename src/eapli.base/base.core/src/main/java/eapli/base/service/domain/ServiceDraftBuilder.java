package eapli.base.service.domain;

import eapli.base.servicecatalog.domain.Icon;
import eapli.base.servicecatalog.domain.ServiceCatalog;
import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;

import java.util.Set;

public class ServiceDraftBuilder implements DomainFactory<ServiceDraft> {

    private Long id;
    private Designation name;
    private ServiceCatalog serviceCatalog;
    private Description shortDesc;
    private Description longDesc;
    private ApprovalTask approvalTask;
    private Form form;
    private TaskSpec taskSpec;
    private Icon icon;
    private Set<KeyWord> keyWords;
    private boolean complete;

    public ServiceDraftBuilder() {
    }

    @Override
    public ServiceDraft build() {
        return new ServiceDraft(this.name, this.serviceCatalog, this.keyWords, this.taskSpec, this.shortDesc, this.longDesc, this.icon, this.approvalTask, this.form, this.complete);
    }

    public ServiceDraftBuilder with(String name, ServiceCatalog serviceCatalog, String shortDesc, String longDesc,
                               ApprovalTask approvalTask, Form form, TaskSpec taskSpec, String icon, Set<KeyWord> keyWords, boolean complete) {
        this.withName(name);
        this.withServiceCatalog(serviceCatalog);
        this.withApprovalTask(approvalTask);
        this.withForm(form);
        this.withIcon(icon);
        this.withKeyWords(keyWords);
        this.withLongDesc(longDesc);
        this.withShortDesc(shortDesc);
        this.withTaskSpec(taskSpec);
        this.withComplete(complete);
        return this;
    }
    public ServiceDraftBuilder withComplete(boolean complete) {
        this.complete = complete;
        return this;
    }



    public ServiceDraftBuilder withName(final String name) {
        this.name = Designation.valueOf(name);
        return this;
    }


    public ServiceDraftBuilder withKeyWords(final Set<KeyWord> keyWords){

            this.keyWords = keyWords;

        return this;
    }

    public ServiceDraftBuilder withTaskSpec (final TaskSpec taskSpec){

            this.taskSpec = taskSpec;
        return this;
    }

    public ServiceDraftBuilder withShortDesc (final String shortDesc){

            this.shortDesc = Description.valueOf(shortDesc);
        return this;
    }

    public ServiceDraftBuilder withLongDesc (final String shortDesc){

            this.longDesc = Description.valueOf(shortDesc);
        return this;
    }

    public ServiceDraftBuilder withIcon (final String icon){

            this.icon = new Icon(icon);
        return this;
    }

    public ServiceDraftBuilder withApprovalTask (final ApprovalTask approvalTask){
        this.approvalTask = approvalTask;
        return this;
    }

    public ServiceDraftBuilder withForm (final Form form){
        this.form = form;
        return this;
    }


    public ServiceDraftBuilder withServiceCatalog(final ServiceCatalog sc){
        this.serviceCatalog = sc;
        return this;
    }

}
