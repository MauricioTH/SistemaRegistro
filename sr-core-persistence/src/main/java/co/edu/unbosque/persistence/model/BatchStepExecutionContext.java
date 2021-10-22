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
@Table(name = "BATCH_STEP_EXECUTION_CONTEXT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BatchStepExecutionContext.findAll", query = "SELECT b FROM BatchStepExecutionContext b"),
    @NamedQuery(name = "BatchStepExecutionContext.findByStepExecutionId", query = "SELECT b FROM BatchStepExecutionContext b WHERE b.stepExecutionId = :stepExecutionId"),
    @NamedQuery(name = "BatchStepExecutionContext.findByShortContext", query = "SELECT b FROM BatchStepExecutionContext b WHERE b.shortContext = :shortContext")})
public class BatchStepExecutionContext implements PersistentObject{

    private static final long serialVersionUID = 10L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "STEP_EXECUTION_ID")
    private BigDecimal stepExecutionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2500)
    @Column(name = "SHORT_CONTEXT")
    private String shortContext;
    @Lob
    @Column(name = "SERIALIZED_CONTEXT")
    private String serializedContext;
    @JoinColumn(name = "STEP_EXECUTION_ID", referencedColumnName = "STEP_EXECUTION_ID", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private BatchStepExecution batchStepExecution;

    public BatchStepExecutionContext() {
    }

    public BatchStepExecutionContext(BigDecimal stepExecutionId) {
        this.stepExecutionId = stepExecutionId;
    }

    public BatchStepExecutionContext(BigDecimal stepExecutionId, String shortContext) {
        this.stepExecutionId = stepExecutionId;
        this.shortContext = shortContext;
    }

    public BigDecimal getStepExecutionId() {
        return stepExecutionId;
    }

    public void setStepExecutionId(BigDecimal stepExecutionId) {
        this.stepExecutionId = stepExecutionId;
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

    public BatchStepExecution getBatchStepExecution() {
        return batchStepExecution;
    }

    public void setBatchStepExecution(BatchStepExecution batchStepExecution) {
        this.batchStepExecution = batchStepExecution;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stepExecutionId != null ? stepExecutionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BatchStepExecutionContext)) {
            return false;
        }
        BatchStepExecutionContext other = (BatchStepExecutionContext) object;
        if ((this.stepExecutionId == null && other.stepExecutionId != null) || (this.stepExecutionId != null && !this.stepExecutionId.equals(other.stepExecutionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.ath.pse.persistence.model.BatchStepExecutionContext[ stepExecutionId=" + stepExecutionId + " ]";
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
