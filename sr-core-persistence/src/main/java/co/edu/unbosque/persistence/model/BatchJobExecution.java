/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.persistence.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import co.edu.unbosque.persistence.PersistentObject;

/**
 *
 * @author proveedor_mjtascon
 */
@Entity
@Table(name = "BATCH_JOB_EXECUTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BatchJobExecution.findAll", query = "SELECT b FROM BatchJobExecution b"),
    @NamedQuery(name = "BatchJobExecution.findByJobExecutionId", query = "SELECT b FROM BatchJobExecution b WHERE b.jobExecutionId = :jobExecutionId"),
    @NamedQuery(name = "BatchJobExecution.findByVersion", query = "SELECT b FROM BatchJobExecution b WHERE b.version = :version"),
    @NamedQuery(name = "BatchJobExecution.findByCreateTime", query = "SELECT b FROM BatchJobExecution b WHERE b.createTime = :createTime"),
    @NamedQuery(name = "BatchJobExecution.findByStartTime", query = "SELECT b FROM BatchJobExecution b WHERE b.startTime = :startTime"),
    @NamedQuery(name = "BatchJobExecution.findByEndTime", query = "SELECT b FROM BatchJobExecution b WHERE b.endTime = :endTime"),
    @NamedQuery(name = "BatchJobExecution.findByStatus", query = "SELECT b FROM BatchJobExecution b WHERE b.status = :status"),
    @NamedQuery(name = "BatchJobExecution.findByExitCode", query = "SELECT b FROM BatchJobExecution b WHERE b.exitCode = :exitCode"),
    @NamedQuery(name = "BatchJobExecution.findByExitMessage", query = "SELECT b FROM BatchJobExecution b WHERE b.exitMessage = :exitMessage"),
    @NamedQuery(name = "BatchJobExecution.findByLastUpdated", query = "SELECT b FROM BatchJobExecution b WHERE b.lastUpdated = :lastUpdated"),
    @NamedQuery(name = "BatchJobExecution.findByJobConfigurationLocation", query = "SELECT b FROM BatchJobExecution b WHERE b.jobConfigurationLocation = :jobConfigurationLocation")})
public class BatchJobExecution implements PersistentObject {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "JOB_EXECUTION_ID")
    private BigDecimal jobExecutionId;
    @Column(name = "VERSION")
    private BigInteger version;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(name = "START_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Column(name = "END_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @Size(max = 10)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 2500)
    @Column(name = "EXIT_CODE")
    private String exitCode;
    @Size(max = 2500)
    @Column(name = "EXIT_MESSAGE")
    private String exitMessage;
    @Column(name = "LAST_UPDATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;
    @Size(max = 2500)
    @Column(name = "JOB_CONFIGURATION_LOCATION")
    private String jobConfigurationLocation;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "batchJobExecution", fetch = FetchType.EAGER)
    private BatchJobExecutionContext batchJobExecutionContext;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobExecutionId", fetch = FetchType.EAGER)
    private List<BatchStepExecution> batchStepExecutionList;
    @JoinColumn(name = "JOB_INSTANCE_ID", referencedColumnName = "JOB_INSTANCE_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BatchJobInstance jobInstanceId;

    public BatchJobExecution() {
    }

    public BatchJobExecution(BigDecimal jobExecutionId) {
        this.jobExecutionId = jobExecutionId;
    }

    public BatchJobExecution(BigDecimal jobExecutionId, Date createTime) {
        this.jobExecutionId = jobExecutionId;
        this.createTime = createTime;
    }

    public BigDecimal getJobExecutionId() {
        return jobExecutionId;
    }

    public void setJobExecutionId(BigDecimal jobExecutionId) {
        this.jobExecutionId = jobExecutionId;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExitCode() {
        return exitCode;
    }

    public void setExitCode(String exitCode) {
        this.exitCode = exitCode;
    }

    public String getExitMessage() {
        return exitMessage;
    }

    public void setExitMessage(String exitMessage) {
        this.exitMessage = exitMessage;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getJobConfigurationLocation() {
        return jobConfigurationLocation;
    }

    public void setJobConfigurationLocation(String jobConfigurationLocation) {
        this.jobConfigurationLocation = jobConfigurationLocation;
    }

    public BatchJobExecutionContext getBatchJobExecutionContext() {
        return batchJobExecutionContext;
    }

    public void setBatchJobExecutionContext(BatchJobExecutionContext batchJobExecutionContext) {
        this.batchJobExecutionContext = batchJobExecutionContext;
    }

    @XmlTransient
    public List<BatchStepExecution> getBatchStepExecutionList() {
        return batchStepExecutionList;
    }

    public void setBatchStepExecutionList(List<BatchStepExecution> batchStepExecutionList) {
        this.batchStepExecutionList = batchStepExecutionList;
    }

    public BatchJobInstance getJobInstanceId() {
        return jobInstanceId;
    }

    public void setJobInstanceId(BatchJobInstance jobInstanceId) {
        this.jobInstanceId = jobInstanceId;
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
        if (!(object instanceof BatchJobExecution)) {
            return false;
        }
        BatchJobExecution other = (BatchJobExecution) object;
        if ((this.jobExecutionId == null && other.jobExecutionId != null) || (this.jobExecutionId != null && !this.jobExecutionId.equals(other.jobExecutionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.ath.pse.persistence.model.BatchJobExecution[ jobExecutionId=" + jobExecutionId + " ]";
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
