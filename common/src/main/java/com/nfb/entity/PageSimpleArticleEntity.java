package com.nfb.entity;

import javax.persistence.*;

/**
 * Created by dengfs on 2015/8/29.
 */
@Entity
@Table(name = "page_simple_article", schema = "", catalog = "fastbuild")
public class PageSimpleArticleEntity {
    private int id;
    private Integer pageId;
    private Integer simpleArticleId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "page_id", nullable = true, insertable = true, updatable = true)
    public Integer getPageId() {
        return pageId;
    }

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    @Basic
    @Column(name = "simple_article_id", nullable = true, insertable = true, updatable = true)
    public Integer getSimpleArticleId() {
        return simpleArticleId;
    }

    public void setSimpleArticleId(Integer simpleArticleId) {
        this.simpleArticleId = simpleArticleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PageSimpleArticleEntity that = (PageSimpleArticleEntity) o;

        if (id != that.id) return false;
        if (pageId != null ? !pageId.equals(that.pageId) : that.pageId != null) return false;
        if (simpleArticleId != null ? !simpleArticleId.equals(that.simpleArticleId) : that.simpleArticleId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (pageId != null ? pageId.hashCode() : 0);
        result = 31 * result + (simpleArticleId != null ? simpleArticleId.hashCode() : 0);
        return result;
    }
}
