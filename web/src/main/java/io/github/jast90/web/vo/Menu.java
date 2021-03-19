package io.github.jast90.web.vo;

/**
 * Created by jast90 on 2021/3/9
 */
public class Menu {
    private Long id;
    private Long parentId;
    private String icon;
    private String href;
    private String name;

    public Menu() {
    }

    public Menu(Long id, Long parentId, String icon, String href, String name) {
        this.id = id;
        this.parentId = parentId;
        this.icon = icon;
        this.href = href;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
