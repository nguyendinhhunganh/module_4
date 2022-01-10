function handleSearch() {
    let searchName = $("#search-name").val();
    $.ajax({
        type: "GET",
        url: "/blog/search/" + searchName,
        datatype: "json",
        success: function (response) {
            var result = "";
            for (let i = 0; i < response.content.length; i++) {
                result += `<tr>
                            <td>${response.content[i].blogId}</td>
                            <td>${response.content[i].blogName}</td>
                            <td>${response.content[i].blogSummary}</td>
                            <td>${response.content[i].category.categoryName}</td>
                            <td>
                                <a th:href="@{/blog/content/__${response.content[i].blogId}__}">
                                    <button class="btn btn-success">Content</button>
                                </a>
                             </td>
                            <td>
                                <a th:href="@{/blog/edit/__${response.content[i].blogId}__}">
                                    <button class="btn btn-success">Edit</button>
                                </a>
                            </td>
                            <td>
                                <a th:href="@{/blog/delete/__${response.content[i].blogId}__}">
                                    <button class="btn btn-danger">Delete</button>
                                </a>
                            </td></tr>`;
            }
            $("#list-blog").html(result);
        }
    });
}