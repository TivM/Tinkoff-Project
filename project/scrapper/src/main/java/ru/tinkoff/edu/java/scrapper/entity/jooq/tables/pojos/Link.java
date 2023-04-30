/*
 * This file is generated by jOOQ.
 */
package ru.tinkoff.edu.java.scrapper.entity.jooq.tables.pojos;


import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import javax.annotation.processing.Generated;
import java.beans.ConstructorProperties;
import java.io.Serializable;
import java.time.OffsetDateTime;


/**
 * This class is generated by jOOQ.
 */
@Generated(
        value = {
                "https://www.jooq.org",
                "jOOQ version:3.17.6"
        },
        comments = "This class is generated by jOOQ"
)
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class Link implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String url;
    private OffsetDateTime lastCheckTime;
    private OffsetDateTime updatedAt;
    private Integer updatesCount;

    public Link() {
    }

    public Link(Link value) {
        this.id = value.id;
        this.url = value.url;
        this.lastCheckTime = value.lastCheckTime;
        this.updatedAt = value.updatedAt;
        this.updatesCount = value.updatesCount;
    }

    @ConstructorProperties({"id", "url", "lastCheckTime", "updatedAt", "updatesCount"})
    public Link(
            @NotNull Long id,
            @NotNull String url,
            @Nullable OffsetDateTime lastCheckTime,
            @Nullable OffsetDateTime updatedAt,
            @Nullable Integer updatesCount
    ) {
        this.id = id;
        this.url = url;
        this.lastCheckTime = lastCheckTime;
        this.updatedAt = updatedAt;
        this.updatesCount = updatesCount;
    }

    /**
     * Getter for <code>LINK.ID</code>.
     */
    @NotNull
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>LINK.ID</code>.
     */
    public void setId(@NotNull Long id) {
        this.id = id;
    }

    /**
     * Getter for <code>LINK.URL</code>.
     */
    @jakarta.validation.constraints.NotNull
    @Size(max = 1000000000)
    @NotNull
    public String getUrl() {
        return this.url;
    }

    /**
     * Setter for <code>LINK.URL</code>.
     */
    public void setUrl(@NotNull String url) {
        this.url = url;
    }

    /**
     * Getter for <code>LINK.LAST_CHECK_TIME</code>.
     */
    @Nullable
    public OffsetDateTime getLastCheckTime() {
        return this.lastCheckTime;
    }

    /**
     * Setter for <code>LINK.LAST_CHECK_TIME</code>.
     */
    public void setLastCheckTime(@Nullable OffsetDateTime lastCheckTime) {
        this.lastCheckTime = lastCheckTime;
    }

    /**
     * Getter for <code>LINK.UPDATED_AT</code>.
     */
    @Nullable
    public OffsetDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    /**
     * Setter for <code>LINK.UPDATED_AT</code>.
     */
    public void setUpdatedAt(@Nullable OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * Getter for <code>LINK.UPDATES_COUNT</code>.
     */
    @Nullable
    public Integer getUpdatesCount() {
        return this.updatesCount;
    }

    /**
     * Setter for <code>LINK.UPDATES_COUNT</code>.
     */
    public void setUpdatesCount(@Nullable Integer updatesCount) {
        this.updatesCount = updatesCount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Link other = (Link) obj;
        if (this.id == null) {
            if (other.id != null)
                return false;
        } else if (!this.id.equals(other.id))
            return false;
        if (this.url == null) {
            if (other.url != null)
                return false;
        } else if (!this.url.equals(other.url))
            return false;
        if (this.lastCheckTime == null) {
            if (other.lastCheckTime != null)
                return false;
        } else if (!this.lastCheckTime.equals(other.lastCheckTime))
            return false;
        if (this.updatedAt == null) {
            if (other.updatedAt != null)
                return false;
        } else if (!this.updatedAt.equals(other.updatedAt))
            return false;
        if (this.updatesCount == null) {
            if (other.updatesCount != null)
                return false;
        } else if (!this.updatesCount.equals(other.updatesCount))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        result = prime * result + ((this.url == null) ? 0 : this.url.hashCode());
        result = prime * result + ((this.lastCheckTime == null) ? 0 : this.lastCheckTime.hashCode());
        result = prime * result + ((this.updatedAt == null) ? 0 : this.updatedAt.hashCode());
        result = prime * result + ((this.updatesCount == null) ? 0 : this.updatesCount.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Link (");

        sb.append(id);
        sb.append(", ").append(url);
        sb.append(", ").append(lastCheckTime);
        sb.append(", ").append(updatedAt);
        sb.append(", ").append(updatesCount);

        sb.append(")");
        return sb.toString();
    }
}