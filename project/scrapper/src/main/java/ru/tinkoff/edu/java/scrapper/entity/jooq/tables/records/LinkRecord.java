/*
 * This file is generated by jOOQ.
 */
package ru.tinkoff.edu.java.scrapper.entity.jooq.tables.records;


import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.beans.ConstructorProperties;
import java.time.OffsetDateTime;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;

import ru.tinkoff.edu.java.scrapper.entity.jooq.tables.Link;


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
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LinkRecord extends UpdatableRecordImpl<LinkRecord> implements Record5<Long, String, OffsetDateTime, OffsetDateTime, Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>LINK.ID</code>.
     */
    public void setId(@NotNull Long value) {
        set(0, value);
    }

    /**
     * Getter for <code>LINK.ID</code>.
     */
    @NotNull
    public Long getId() {
        return (Long) get(0);
    }

    /**
     * Setter for <code>LINK.URL</code>.
     */
    public void setUrl(@NotNull String value) {
        set(1, value);
    }

    /**
     * Getter for <code>LINK.URL</code>.
     */
    @jakarta.validation.constraints.NotNull
    @Size(max = 1000000000)
    @NotNull
    public String getUrl() {
        return (String) get(1);
    }

    /**
     * Setter for <code>LINK.LAST_CHECK_TIME</code>.
     */
    public void setLastCheckTime(@Nullable OffsetDateTime value) {
        set(2, value);
    }

    /**
     * Getter for <code>LINK.LAST_CHECK_TIME</code>.
     */
    @Nullable
    public OffsetDateTime getLastCheckTime() {
        return (OffsetDateTime) get(2);
    }

    /**
     * Setter for <code>LINK.UPDATED_AT</code>.
     */
    public void setUpdatedAt(@Nullable OffsetDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>LINK.UPDATED_AT</code>.
     */
    @Nullable
    public OffsetDateTime getUpdatedAt() {
        return (OffsetDateTime) get(3);
    }

    /**
     * Setter for <code>LINK.UPDATES_COUNT</code>.
     */
    public void setUpdatesCount(@Nullable Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>LINK.UPDATES_COUNT</code>.
     */
    @Nullable
    public Integer getUpdatesCount() {
        return (Integer) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    @NotNull
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    @NotNull
    public Row5<Long, String, OffsetDateTime, OffsetDateTime, Integer> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    @NotNull
    public Row5<Long, String, OffsetDateTime, OffsetDateTime, Integer> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    @NotNull
    public Field<Long> field1() {
        return Link.LINK.ID;
    }

    @Override
    @NotNull
    public Field<String> field2() {
        return Link.LINK.URL;
    }

    @Override
    @NotNull
    public Field<OffsetDateTime> field3() {
        return Link.LINK.LAST_CHECK_TIME;
    }

    @Override
    @NotNull
    public Field<OffsetDateTime> field4() {
        return Link.LINK.UPDATED_AT;
    }

    @Override
    @NotNull
    public Field<Integer> field5() {
        return Link.LINK.UPDATES_COUNT;
    }

    @Override
    @NotNull
    public Long component1() {
        return getId();
    }

    @Override
    @NotNull
    public String component2() {
        return getUrl();
    }

    @Override
    @Nullable
    public OffsetDateTime component3() {
        return getLastCheckTime();
    }

    @Override
    @Nullable
    public OffsetDateTime component4() {
        return getUpdatedAt();
    }

    @Override
    @Nullable
    public Integer component5() {
        return getUpdatesCount();
    }

    @Override
    @NotNull
    public Long value1() {
        return getId();
    }

    @Override
    @NotNull
    public String value2() {
        return getUrl();
    }

    @Override
    @Nullable
    public OffsetDateTime value3() {
        return getLastCheckTime();
    }

    @Override
    @Nullable
    public OffsetDateTime value4() {
        return getUpdatedAt();
    }

    @Override
    @Nullable
    public Integer value5() {
        return getUpdatesCount();
    }

    @Override
    @NotNull
    public LinkRecord value1(@NotNull Long value) {
        setId(value);
        return this;
    }

    @Override
    @NotNull
    public LinkRecord value2(@NotNull String value) {
        setUrl(value);
        return this;
    }

    @Override
    @NotNull
    public LinkRecord value3(@Nullable OffsetDateTime value) {
        setLastCheckTime(value);
        return this;
    }

    @Override
    @NotNull
    public LinkRecord value4(@Nullable OffsetDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    @NotNull
    public LinkRecord value5(@Nullable Integer value) {
        setUpdatesCount(value);
        return this;
    }

    @Override
    @NotNull
    public LinkRecord values(@NotNull Long value1, @NotNull String value2, @Nullable OffsetDateTime value3, @Nullable OffsetDateTime value4, @Nullable Integer value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LinkRecord
     */
    public LinkRecord() {
        super(Link.LINK);
    }

    /**
     * Create a detached, initialised LinkRecord
     */
    @ConstructorProperties({ "id", "url", "lastCheckTime", "updatedAt", "updatesCount" })
    public LinkRecord(@NotNull Long id, @NotNull String url, @Nullable OffsetDateTime lastCheckTime, @Nullable OffsetDateTime updatedAt, @Nullable Integer updatesCount) {
        super(Link.LINK);

        setId(id);
        setUrl(url);
        setLastCheckTime(lastCheckTime);
        setUpdatedAt(updatedAt);
        setUpdatesCount(updatesCount);
    }

    /**
     * Create a detached, initialised LinkRecord
     */
    public LinkRecord(ru.tinkoff.edu.java.scrapper.entity.jooq.tables.pojos.Link value) {
        super(Link.LINK);

        if (value != null) {
            setId(value.getId());
            setUrl(value.getUrl());
            setLastCheckTime(value.getLastCheckTime());
            setUpdatedAt(value.getUpdatedAt());
            setUpdatesCount(value.getUpdatesCount());
        }
    }
}
