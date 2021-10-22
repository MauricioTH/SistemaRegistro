/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.persistence.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import co.edu.unbosque.persistence.PersistentObject;

/**
 *
 * @author proveedor_mjtascon
 */
@Entity
@Table(name = "BATCH_JOB_EXECUTION_CONTEXT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BatchJobExecutionContext.findAll", query = "SELECT b FROM BatchJobExecutionContext b"),
    @NamedQuery(name = "BatchJobExecutionContext.findByJobExecutionId", query = "SELECT b FROM BatchJobExecutionContext b WHERE b.jobExecutionId = :jobExecutionId"),
    @NamedQuery(name = "BatchJobExecutionContext.findByShortContext", query = "SELECT b FROM BatchJobExecutionContext b WHERE b.shortContext = :shortContext")})
public class BatchJobExecutionContext implements PersistentObject {

    private static final long serialVersionUID = 10L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "JOB_EXECUTION_ID")
    private BigDecimal jobExecutionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2500)
    @Column(name = "SHORT_CONTEXT")
    private String shortContext;
    @Lob
    @Column(name = "SERIALIZED_CONTEXT")
    private String serializedContext;
    @JoinColumn(name = "JOB_EXECUTION_ID", referencedColumnName = "JOB_EXECUTION_ID", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private BatchJobExecution batchJobExecution;

    public BatchJobExecutionContext() {
    }

    public BatchJobExecutionContext(BigDecimal jobExecutionId) {
        this.jobExecutionId = jobExecutionId;
    }

    public BatchJobExecutionContext(BigDecimal jobExecutionId, String shortContext) {
        this.jobExecutionId = jobExecutionId;
        this.shortContext = shortContext;
    }

    public BigDecimal getJobExecutionId() {
        return jobExecutionId;
    }

    public void setJobExecutionId(BigDecimal jobExecutionId) {
        this.jobExecutionId = jobExecutionId;
    }

    public String getShortContext() {
        return shortContext;
    }

    public void setShortContext(String shortContext) {
        this.shortContext = shortContext;
    }

    public String getSerializedContext() {
        return serializedContext;
    }

    public void setSerializedContext(String serializedContext) {
        this.serializedContext = serializedContext;
    }

    public BatchJobExecution getBatchJobExecution() {
        return batchJobExecution;
    }

    public void setBatchJobExecution(BatchJobExecution batchJobExecution) {
        this.batchJobExecution = batchJobExecution;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jobExecutionId != null ? jobExecutionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BatchJobExecutionContext)) {
            return false;
        }
        BatchJobExecutionContext other = (BatchJobExecutionContext) object;
        if ((this.jobExecutionId == null && other.jobExecutionId != null) || (this.jobExecutionId != null && !this.jobExecutionId.equals(other.jobExecutionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.ath.pse.persistence.model.BatchJobExecutionContext[ jobExecutionId=" + jobExecutionId + " ]";
    }

	@Override
	public boolean isRowDeleted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setRowDeleted(boolean rowDeleted) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Date getRowCreationDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRowCreationDate(Date rowCreationDate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Date getRowLastUpdate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRowLastUpdate(Date rowLastUpdate) {
		// TODO Auto-generated method stub
		
	}
    
}
