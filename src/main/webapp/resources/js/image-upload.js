/**
 * Created by damma on 01.12.2016.
 */

var handleFileSelect = function (evt) {
    var files = evt.target.files;
    var file = files[0];

    if (files && file) {
        var reader = new FileReader();

        reader.onload = function (readerEvt) {
            var binaryString = readerEvt.target.result;
            document.getElementById("hiddenImage").value = btoa(binaryString);
        };

        reader.readAsBinaryString(file);
    }
};

if (window.File && window.FileReader && window.FileList && window.Blob) {
    document.getElementById('image').addEventListener('change', handleFileSelect, false);
} else {
    alert('The File APIs are not fully supported in this browser.');
}
