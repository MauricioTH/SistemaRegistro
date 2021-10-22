/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.persistence.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import co.edu.unbosque.persistence.PersistentObject;

/**
 *
 * @author proveedor_mjtascon
 */
@Entity
@Table(name = "BATCH_STEP_EXECUTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BatchStepExecution.findAll", query = "SELECT b FROM BatchStepExecution b"),
    @NamedQuery(name = "BatchStepExecution.findByStepExecutionId", query = "SELECT b FROM BatchStepExecution b WHERE b.stepExecutionId = :stepExecutionId"),
    @NamedQuery(name = "BatchStepExecution.findByVersion", query = "SELECT b FROM BatchStepExecution b WHERE b.version = :version"),
    @NamedQuery(name = "BatchStepExecution.findByStepName", query = "SELECT b FROM BatchStepExecution b WHERE b.stepName = :stepName"),
    @NamedQuery(name = "BatchStepExecution.findByStartTime", query = "SELECT b FROM BatchStepExecution b WHERE b.startTime = :startTime"),
    @NamedQuery(name = "BatchStepExecution.findByEndTime", query = "SELECT b FROM BatchStepExecution b WHERE b.endTime = :endTime"),
    @NamedQuery(name = "BatchStepExecution.findByStatus", query = "SELECT b FROM BatchStepExecution b WHERE b.status = :status"),
    @NamedQuery(name = "BatchStepExecution.findByCommitCount", query = "SELECT b FROM BatchStepExecution b WHERE b.commitCount = :commitCount"),
    @NamedQuery(name = "BatchStepExecution.findByReadCount", query = "SELECT b FROM BatchStepExecution b WHERE b.readCount = :readCount"),
    @NamedQuery(name = "BatchStepExecution.findByFilterCount", query = "SELECT b FROM BatchStepExecution b WHERE b.filterCount = :filterCount"),
    @NamedQuery(name = "BatchStepExecution.findByWriteCount", query = "SELECT b FROM BatchStepExecution b WHERE b.writeCount = :writeCount"),
    @NamedQuery(name = "BatchStepExecution.findByReadSkipCount", query = "SELECT b FROM BatchStepExecution b WHERE b.readSkipCount = :readSkipCount"),
    @NamedQuery(name = "BatchStepExecution.findByWriteSkipCount", query = "SELECT b FROM BatchStepExecution b WHERE b.writeSkipCount = :writeSkipCount"),
    @NamedQuery(name = "BatchStepExecution.findByProcessSkipCount", query = "SELECT b FROM BatchStepExecution b WHERE b.processSkipCount = :processSkipCount"),
    @NamedQuery(name = "BatchStepExecution.findByRollbackCount", query = "SELECT b FROM BatchStepExecution b WHERE b.rollbackCount = :rollbackCount"),
    @NamedQuery(name = "BatchStepExecution.findByExitCode", query = "SELECT b FROM BatchStepExecution b WHERE b.exitCode = :exitCode"),
    @NamedQuery(name = "BatchStepExecution.findByExitMessage", query = "SELECT b FROM BatchStepExecution b WHERE b.exitMessage = :exitMessage"),
    @NamedQuery(name = "BatchStepExecution.findByLastUpdated", query = "SELECT b FROM BatchStepExecution b WHERE b.lastUpdated = :lastUpdated")})
public class BatchStepExecution implements PersistentObject {

    private static final long serialVersionUID = 10L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "STEP_EXECUTION_ID")
    private BigDecimal stepExecutionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VERSION")
    private BigInteger version;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "STEP_NAME")
    private String stepName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "START_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Column(name = "END_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @Size(max = 10)
    @Column(name = "STATUS")
    private String status;
    @Column(name = "COMMIT_COUNT")
    private BigInteger commitCount;
    @Column(name = "READ_COUNT")
    private BigInteger readCount;
    @Column(name = "FILTER_COUNT")
    private BigInteger filterCount;
    @Column(name = "WRITE_COUNT")
    private BigInteger writeCount;
    @Column(name = "READ_SKIP_COUNT")
    private BigInteger readSkipCount;
    @Column(name = "WRITE_SKIP_COUNT")
    private BigInteger writeSkipCount;
    @Column(name = "PROCESS_SKIP_COUNT")
    private BigInteger processSkipCount;
    @Column(name = "ROLLBACK_COUNT")
    private BigInteger rollbackCount;
    @Size(max = 2500)
    @Column(name = "EXIT_CODE")
    private String exitCode;
    @Size(max = 2500)
    @Column(name = "EXIT_MESSAGE")
    private String exitMessage;
    @Column(name = "LAST_UPDATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;
    @JoinColumn(name = "JOB_EXECUTION_ID", referencedColumnName = "JOB_EXECUTION_ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BatchJobExecution jobExecutionId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "batchStepExecution", fetch = FetchType.EAGER)
    private BatchStepExecutionContext batchStepExecutionContext;

    public BatchStepExecution() {
    }

    public BatchStepExecution(BigDecimal stepExecutionId) {
        this.stepExecutionId = stepExecutionId;
    }

    public BatchStepExecution(BigDecimal stepExecutionId, BigInteger version, String stepName, Date startTime) {
        this.stepExecutionId = stepExecutionId;
        this.version = version;
        this.stepName = stepName;
        this.startTime = startTime;
    }

    public BigDecimal getStepExecutionId() {
        return stepExecutionId;
    }

    public void setStepExecutionId(BigDecimal stepExecutionId) {
        this.stepExecutionId = stepExecutionId;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName;
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

    public BigInteger getCommitCount() {
        return commitCount;
    }

    public void setCommitCount(BigInteger commitCount) {
        this.commitCount = commitCount;
    }

    public BigInteger getReadCount() {
        return readCount;
    }

    public void setReadCount(BigInteger readCount) {
        this.readCount = readCount;
    }

    public BigInteger getFilterCount() {
        return filterCount;
    }

    public void setFilterCount(BigInteger filterCount) {
        this.filterCount = filterCount;
    }

    public BigInteger getWriteCount() {
        return writeCount;
    }

    public void setWriteCount(BigInteger writeCount) {
        this.writeCount = writeCount;
    }

    public BigInteger getReadSkipCount() {
        return readSkipCount;
    }

    public void setReadSkipCount(BigInteger readSkipCount) {
        this.readSkipCount = readSkipCount;
    }

    public BigInteger getWriteSkipCount() {
        return writeSkipCount;
    }

    public void setWriteSkipCount(BigInteger writeSkipCount) {
        this.writeSkipCount = writeSkipCount;
    }

    public BigInteger getProcessSkipCount() {
        return processSkipCount;
    }

    public void setProcessSkipCount(BigInteger processSkipCount) {
        this.processSkipCount = processSkipCount;
    }

    public BigInteger getRollbackCount() {
        return rollbackCount;
    }

    public void setRollbackCount(BigInteger rollbackCount) {
        this.rollbackCount = rollbackCount;
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

    public BatchJobExecution getJobExecutionId() {
        return jobExecutionId;
    }

    public void setJobExecutionId(BatchJobExecution jobExecutionId) {
        this.jobExecutionId = jobExecutionId;
    }

    public BatchStepExecutionContext getBatchStepExecutionContext() {
        return batchStepExecutionContext;
    }

    public void setBatchStepExecutionContext(BatchStepExecutionContext batchStepExecutionContext) {
        this.batchStepExecutionContext = batchStepExecutionContext;
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
        if (!(object instanceof BatchStepExecution)) {
            return false;
        }
        BatchStepExecution other = (BatchStepExecution) object;
        if ((this.stepExecutionId == null && other.stepExecutionId != null) || (this.stepExecutionId != null && !this.stepExecutionId.equals(other.stepExecutionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.ath.pse.persistence.model.BatchStepExecution[ stepExecutionId=" + stepExecutionId + " ]";
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
