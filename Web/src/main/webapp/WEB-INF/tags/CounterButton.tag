<%@ tag language="java" pageEncoding="UTF-8"%>

<script>
	class CounterButton{
		constructor(id, value){
			if (value == null){
				this.value = 0;
			}else{
				this.value = value;	
			}
			this.id = id;
			document.getElementById(this.id).innerText = this.value;
		}
		increment(){
			this.value++;
			document.getElementById(this.id).innerText = this.value;
		}
		decrement(){
			if (this.value > 1){
				this.value--;
			}
			document.getElementById(this.id).innerText = this.value;
		}
	}
</script>