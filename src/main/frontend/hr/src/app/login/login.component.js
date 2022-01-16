let toggleVisibility = () => {
    if (document.getElementById("visibility_icon").innerText == "visibility")
    {
        document.getElementById("visibility_icon").innerText  = "visibility_off"
        document.getElementById("upass").type  = "text";
    }
    else
    {
        document.getElementById("visibility_icon").innerText  = "visibility"
        document.getElementById("upass").type  = "password";
    }
}