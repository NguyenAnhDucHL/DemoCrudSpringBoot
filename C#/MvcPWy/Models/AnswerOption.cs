//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace MvcPWy.Models
{
    using System;
    using System.Collections.Generic;
    
    public partial class AnswerOption
    {
        public int answer_option_id { get; set; }
        public int question_id { get; set; }
        public string answer_text { get; set; }
        public bool answer_corect { get; set; }
    
        public virtual Question Question { get; set; }
    }
}
