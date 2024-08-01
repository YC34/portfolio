document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('login-form').addEventListener('submit', function(e) {
        e.preventDefault();
        const form = e.target;
        const formData = new FormData(form);
        const data = {
            username: formData.get('username'),
            password: formData.get('password')
        };

        fetch('/api/auth/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
            .then(response => {
                if (response.ok) {
                    window.location.href = '/'; // 성공 시 홈 페이지로 이동
                } else {
                    window.location.reload(); // 실패 시 현재 페이지로 리로드
                }
            })
            .catch(error => {
                console.error('Error:', error);
                window.location.reload(); // 오류 발생 시 현재 페이지로 리로드
            });
    });
});