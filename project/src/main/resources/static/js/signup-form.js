document.getElementById('signup-form').addEventListener('submit', function(e) {
    e.preventDefault();
    const form = e.target;
    const formData = new FormData(form);
    const data = {
        username: formData.get('username'),
        password: formData.get('password')
    };
    fetch('/api/auth/signup', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => {
            if (response.ok) {
                window.location.href = '/login'; // 성공 시 로그인 페이지로 이동
            } else {
                return response.text().then(text => {
                    alert(text); // 오류 메시지 표시
                    window.location.href = '/signup'; // 오류 시 다시 가입 페이지로 이동
                });
            }
        });
});