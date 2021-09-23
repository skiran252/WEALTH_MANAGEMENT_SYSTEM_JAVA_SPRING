<script>
function logout() {
	  const form = document.createElement('form');
	  form.method = "POST";
	  form.action = "${pageContext.request.contextPath}/logout";
	  const hiddenField = document.createElement('button');
      hiddenField.type = 'submit';
      hiddenField.value="Logout"
      form.appendChild(hiddenField);
      document.body.appendChild(form);
	  form.submit();
	}
</script>