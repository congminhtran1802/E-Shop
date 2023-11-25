
    // Bắt sự kiện khi ấn phím Enter trên ô nhập liệu
    document.getElementById('searchInput').addEventListener('keydown', function (event) {
        if (event.key === 'Enter') {
            document.getElementById('searchForm').submit();
        }
    });
