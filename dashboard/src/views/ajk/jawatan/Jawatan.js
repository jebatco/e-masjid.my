import React, { useState, useEffect, useRef } from 'react'
import { useParams } from 'react-router-dom'
import {
  CCard,
  CCardBody,
  CCardHeader,
  CCol,
  CRow,
  CForm,
  CFormLabel,
  CFormInput,
  CFormTextarea,
  CFormSelect,
  CButton,
  CAccordion,
  CAccordionItem,
  CAccordionHeader,
  CAccordionBody,
  CTable,
  CSpinner,
  CFormCheck,
} from '@coreui/react'
import {saveJawatan, searchJawatan, searchJawatanByTagId, updateJawatan, deleteJawatan} from 'src/service/ajk/JawatanApi'
import { ToastContainer, toast } from 'react-toastify'
import 'react-toastify/dist/ReactToastify.css'
import { useNavigate } from 'react-router-dom'

const columns = [
  {
    key: 'Nama',
    _props: { className: 'w-25', scope: 'col' },
  },
  {
    key: 'Tindakan',
    _props: { className: 'w-25', scope: 'col' },
  },
]
const Jawatan = () => {
  
  const [jawatans, setJawatans] = useState([])
  const [data, setData] = useState([])
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState(null)
  const inputName = useRef()

  useEffect(() => {
    async function fetchJawatan() {
      try {
        const data_fetch = await searchJawatan()             
        const items = data_fetch.map((jawatan) => ({
          Nama: jawatan.nama,
          Tindakan: (
            <CButton color="link" onClick={() => removeJawatan(jawatan.id)}>
              Buang
            </CButton>
          ),
        }))
        
        setJawatans(items)
        setLoading(false)
      } catch (error) {
        setError(error)
        setLoading(false)
      }
    }
    fetchJawatan()
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [data])
  
  const addJawatan = async () => {
    try {
      const inputValue = inputName.current.value
      inputName.current.value = ''
      const jwtn = {
        nama: inputValue,
      }
      await saveJawatan(jwtn)
      setData(jwtn)
    } catch (error) {
      console.error(error)
      toast.error('Tiada akses untuk menyimpan rekod jawatan.', {
        position: 'top-center',
        autoClose: 5000,
        hideProgressBar: false,
        closeOnClick: true,
        pauseOnHover: true,
        draggable: true,
        progress: undefined,
        theme: 'light',
      })
    }
  }

  const removeJawatan = async (id) => {
    try {
      await deleteJawatan(id)
      setData(id)
    } catch (error) {
      toast.error('Tiada akses untuk membuang Jawatan.', {
        position: 'top-center',
        autoClose: 5000,
        hideProgressBar: false,
        closeOnClick: true,
        pauseOnHover: true,
        draggable: true,
        progress: undefined,
        theme: 'light',
      })
    }
  }

  return (
    <CRow>
      <CCol xs={12}>
        <CCard className="mb-4">
          <CCardHeader>
            <ToastContainer />
            <strong>Jawatan</strong>
          </CCardHeader>

          <CCardBody>
            <p className="text-medium-emphasis small">
              Kemaskini nama jawatan
            </p>           
                  <div className="mb-3">
                    <CFormLabel htmlFor="txtJawatan">Nama Jawatan</CFormLabel>
                    <CFormInput
                      maxLength={12}
                      ref={inputName}
                      type="text"
                      id="txtJawatan"
                      placeholder="Nama Jawatan"
                    />
                  </div>
                  <div className="d-grid gap-2">
                    <CButton color="primary" size="sm" onClick={addJawatan}>
                      Tambah tag
                    </CButton>
                  </div>
                  <CTable columns={columns} items={jawatans} responsive="lg" />
                
          </CCardBody>
        </CCard>
      </CCol>
    </CRow>
  )
}

export default Jawatan