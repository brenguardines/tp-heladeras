document.addEventListener("DOMContentLoaded", function () {
    const table = document.querySelector("table");
    const rows = Array.from(table.querySelectorAll("tbody tr"));

    table.querySelector("th:nth-child(1)").addEventListener("click", () => {
        rows.sort((a, b) => {
            const nombreA = a.querySelector("td:nth-child(1)").textContent.trim();
            const nombreB = b.querySelector("td:nth-child(1)").textContent.trim();
            return nombreA.localeCompare(nombreB);
        });

        const tbody = table.querySelector("tbody");
        rows.forEach(row => tbody.appendChild(row));
    });
});
