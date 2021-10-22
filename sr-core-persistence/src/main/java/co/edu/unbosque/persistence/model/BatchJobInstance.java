/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unbosque.persistence.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author proveedor_mjtascon
 */
@Entity
@Table(name = "BATCH_JOB_INSTANCE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BatchJobInstance.findAll", query = "SELECT b FROM BatchJobInstance b"),
    @NamedQuery(name = "BatchJobInstance.findByJobInstanceId", query = "SELECT b FROM BatchJobInstance b WHERE b.jobInstanceId = :jobInstanceId"),
    @NamedQuery(name = "BatchJobInstance.findByVersion", query = "SELECT b FROM BatchJobInstance b WHERE b.version = :version"),
    @NamedQuery(name = "BatchJobInstance.findByJobName", query = "SELECT b FROM BatchJobInstance b WHERE b.jobName = :jobName"),
    @NamedQuery(name = "BatchJobInstance.findByJobKey", query = "SELECT b FROM BatchJobInstance b WHERE b.jobKey = :jobKey")})
public class BatchJobInstance implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "JOB_INSTANCE_ID")
    private BigDecimal jobInstanceId;
    @Column(name = "VERSION")
    private BigInteger version;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "JOB_NAME")
    private String jobName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "JOB_KEY")
    private String jobKey;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobInstanceId", fetch = FetchType.EAGER)
    private List<BatchJobExecution> batchJobExecutionList;

    public BatchJobInstance() {
    }

    public BatchJobInstance(BigDecimal jobInstanceId) {
        this.jobInstanceId = jobInstanceId;
    }

    public BatchJobInstance(BigDecimal jobInstanceId, String jobName, String jobKey) {
        this.jobInstanceId = jobInstanceId;
        this.jobName = jobName;
        this.jobKey = jobKey;
    }

    public BigDecimal getJobInstanceId() {
        return jobInstanceId;
    }

    public void setJobInstanceId(BigDecimal jobInstanceId) {
        this.jobInstanceId = jobInstanceId;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobKey() {
        return jobKey;
    }

    public void setJobKey(String jobKey) {
        this.jobKey = jobKey;
    }

    @XmlTransient
    public List<BatchJobExecution> getBatchJobExecutionList() {
        return batchJobExecutionList;
    }

    public void setBatchJobExecutionList(List<BatchJobExecution> batchJobExecutionList) {
        this.batchJobExecutionList = batchJobExecutionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jobInstanceId != null ? jobInstanceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BatchJobInstance)) {
            return false;
        }
        BatchJobInstance other = (BatchJobInstance) object;
        if ((this.jobInstanceId == null && other.jobInstanceId != null) || (this.jobInstanceId != null && !this.jobInstanceId.equals(other.jobInstanceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.ath.pse.persistence.model.BatchJobInstance[ jobInstanceId=" + jobInstanceId + " ]";
    }
    
}
